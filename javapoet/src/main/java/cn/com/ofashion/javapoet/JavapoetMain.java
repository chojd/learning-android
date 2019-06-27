package cn.com.ofashion.javapoet;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import org.omg.Dynamic.Parameter;

import java.io.IOException;

import javax.lang.model.element.Modifier;

public class JavapoetMain {

    public String makeFileContent() {
        // `JavaFile` 代表 Java 文件

        FieldSpec mField = FieldSpec
                .builder(TypeName.INT, "beanCount", Modifier.PRIVATE, Modifier.FINAL)
                .build();

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
                .addField(mField)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(methodSpec)
                .build();

        JavaFile javaFile = JavaFile
                .builder("cn.com.ofashion.annotation", typeSpec)
                .build();

        return javaFile.toString();
    }
}
