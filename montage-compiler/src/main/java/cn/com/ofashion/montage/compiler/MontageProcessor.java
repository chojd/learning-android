package cn.com.ofashion.montage.compiler;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import cn.com.ofashion.montage.annotation.MontageBean;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MontageProcessor extends AbstractProcessor {

    private ProcessingEnvironment processingEnv;

    static private int flag = 0;

    private final String packageName = "cn.com.ofashion.montage";
    private final String simpleClassName = "MontageFactory";

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        processingEnv = processingEnvironment;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        ArrayList<Integer> typeList = new ArrayList<>();

        if (MontageProcessor.flag == 0) {
            MontageProcessor.flag = 1;

            TypeSpec typeSpec = TypeSpec
                    .classBuilder(simpleClassName)
                    .addModifiers(Modifier.PUBLIC)
                    .addField(hashTableField())
                    .addField(instanceField())
                    .addMethod(constructorMethod())
                    .addMethod(getInstance())
                    .addMethod(registerMethod())
                    .build();

            JavaFile javaFile = JavaFile
                    .builder(packageName, typeSpec)
                    .build();

            try {
                javaFile.writeTo(processingEnv.getFiler());
            } catch (IOException e) {
                printError(null, e.toString());
            }
        }

        for (Element element : roundEnvironment.getElementsAnnotatedWith(MontageBean.class)) {
            TypeElement typeElement = (TypeElement) element;
            if (element.getKind() != ElementKind.CLASS) {
                printError(element, "not support type");
                continue;
            }

            MontageBean annotation = element.getAnnotation(MontageBean.class);

        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> singleton = Collections.singleton(MontageBean.class.getCanonicalName());
        assert singleton.size() == 1;
        return singleton;
    }

    private ParameterSpec typeParameterSpec() {
        ParameterSpec typeParameterSpec = ParameterSpec
                .builder(TypeName.INT, "type", Modifier.FINAL)
                .build();
        return typeParameterSpec;
    }

    private ParameterSpec classNameParameterSpec() {
        ParameterSpec typeParameterSpec = ParameterSpec
                .builder(ClassName.get(String.class), "className", Modifier.FINAL)
                .build();
        return typeParameterSpec;
    }


    private ClassName targetClassName() {
        ClassName montageFactory = ClassName.get(packageName, simpleClassName);
        return montageFactory;
    }

    private MethodSpec getInstance() {
        MethodSpec getInstance = MethodSpec
                .methodBuilder("getInstance")
                .addModifiers(Modifier.STATIC, Modifier.PUBLIC)
                .addCode("return instance;\n")
                .returns(ClassName.get(packageName,simpleClassName))
                .build();
        return getInstance;
    }

    private FieldSpec hashTableField() {
        FieldSpec hashTableField = FieldSpec
                .builder(ClassName.get(Hashtable.class), "hashTable", Modifier.PUBLIC)
                .build();
        return hashTableField;
    }

    private FieldSpec instanceField() {
        FieldSpec instanceField = FieldSpec
                .builder(targetClassName(), "instance", Modifier.PRIVATE, Modifier.STATIC)
                .initializer("new " + simpleClassName + "()")
                .build();
        return instanceField;
    }


    private MethodSpec registerMethod() {
        MethodSpec methodSpec = MethodSpec
                .methodBuilder("registerBean")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(typeParameterSpec())
                .addParameter(classNameParameterSpec())
                .addCode("hashTable.put(type, className);\n")
                .returns(TypeName.VOID)
                .build();
        return methodSpec;
    }


    private MethodSpec constructorMethod() {
        MethodSpec constructorMethod = MethodSpec
                .constructorBuilder()
                .addModifiers(Modifier.PRIVATE)
                .addCode("\nhashTable = new " + Hashtable.class.getSimpleName() + "();\n")
                .build();
        return constructorMethod;
    }

    private void printError(Element element, String message, Object... args) {
        processingEnv.getMessager().
                printMessage(
                        Diagnostic.Kind.ERROR,
                        String.format(message, args),
                        element
                );
    }
}
