import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;

import static org.objectweb.asm.Opcodes.*;
public class Scanner {

    public static void main(String[] args) throws IOException {

    ClassWriter classWriter = new ClassWriter(0);
    MethodVisitor mv;

    classWriter.visit(V11, ACC_PUBLIC | ACC_SUPER, "Scanner", null, "java/lang/Object", null);

    classWriter.visitSource("Scanner.java", null);

    {
        mv = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        Label label0 = new Label();
        mv.visitLabel(label0);
        mv.visitLineNumber(8, label0);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(RETURN);
        Label label1 = new Label();
        mv.visitLabel(label1);
        mv.visitLocalVariable("this", "LScannerTest;", null, label0, label1, 0);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
    }
    {
        mv = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, new String[] { "java/io/IOException" });
        mv.visitCode();
        Label label0 = new Label();
        mv.visitLabel(label0);
        mv.visitLineNumber(11, label0);
        mv.visitTypeInsn(NEW, "java/util/Scanner");
        mv.visitInsn(DUP);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
        mv.visitMethodInsn(INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
        mv.visitVarInsn(ASTORE, 1);
        Label label1 = new Label();
        mv.visitLabel(label1);
        mv.visitLineNumber(12, label1);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("Enter an integer: ");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        Label label2 = new Label();
        mv.visitLabel(label2);
        mv.visitLineNumber(13, label2);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
        mv.visitVarInsn(ISTORE, 2);
        Label label3 = new Label();
        mv.visitLabel(label3);
        mv.visitLineNumber(14, label3);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("Enter a Double: ");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        Label label4 = new Label();
        mv.visitLabel(label4);
        mv.visitLineNumber(15, label4);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextDouble", "()D", false);
        mv.visitVarInsn(DSTORE, 3);
        Label label5 = new Label();
        mv.visitLabel(label5);
        mv.visitLineNumber(16, label5);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("Enter a Long: ");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        Label label6 = new Label();
        mv.visitLabel(label6);
        mv.visitLineNumber(17, label6);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextLong", "()J", false);
        mv.visitVarInsn(LSTORE, 5);
        Label label9 = new Label();
        mv.visitLabel(label9);
        mv.visitLineNumber(21, label9);
        mv.visitInsn(RETURN);
        Label label10 = new Label();
        mv.visitLabel(label10);
        mv.visitLocalVariable("args", "[Ljava/lang/String;", null, label0, label10, 0);
        mv.visitLocalVariable("in", "Ljava/util/Scanner;", null, label1, label10, 1);
        mv.visitLocalVariable("iIn", "I", null, label3, label10, 2);
        mv.visitLocalVariable("dIn", "D", null, label5, label10, 3);
        mv.visitMaxs(8, 7);
        mv.visitEnd();
    }
        classWriter.visitEnd();

        FileOutputStream out=new FileOutputStream("../bin/Scanner.class");
        out.write(classWriter.toByteArray());
        out.close();
    }
}