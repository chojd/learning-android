package cn.com.ofashion.montage.compiler;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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

//            FieldSpec mField = FieldSpec
//                    .builder(TypeName.INT, "beanCount", Modifier.PRIVATE, Modifier.FINAL)
//                    .build();

            ParameterSpec parameterSpec = ParameterSpec
                    .builder(String.class, "greet")
                    .build();

            MethodSpec methodSpec = MethodSpec
                    .methodBuilder("helloWorld")
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(parameterSpec)
                    .returns(void.class)
                    .addStatement("System.out.println(greet)")
                    .build();

            TypeSpec typeSpec = TypeSpec
                    .classBuilder("MontageFactory")
//                    .addField(mField)
                    .addModifiers(Modifier.PUBLIC)
                    .addMethod(methodSpec)
                    .build();

            JavaFile javaFile = JavaFile
                    .builder("cn.com.ofashion.montage", typeSpec)
                    .build();

            try {
                javaFile.writeTo(processingEnv.getFiler());
            } catch (IOException e) {
                printError(null, e.toString());
            }
        }

        for (Element element: roundEnvironment.getElementsAnnotatedWith(MontageBean.class)) {
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

    private void printError(Element element, String message, Object... args) {
        processingEnv.getMessager().
                printMessage(
                        Diagnostic.Kind.ERROR,
                        String.format(message, args),
                        element
                );
    }
}
