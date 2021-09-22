import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;

import static org.objectweb.asm.Opcodes.*;

public class Accumulator {

	public static void main(String[] args) throws IOException{
		
		ClassWriter cw=new ClassWriter(0);
		cw.visit(V11, ACC_PUBLIC+ACC_SUPER, "Acc", null, "java/lang/Object", null);
	
		//Create the class
		{
			MethodVisitor mv=cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}
		
		//create the main method
		{
            MethodVisitor methodVisitor=cw.visitMethod(ACC_PUBLIC+ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(4, label0);
            methodVisitor.visitTypeInsn(NEW, "java/util/Scanner");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
            methodVisitor.visitVarInsn(ASTORE, 1);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(6, label1);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitLdcInsn("Enter an integer: ");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(7, label2);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
            methodVisitor.visitVarInsn(ISTORE, 2);
            Label label3 = new Label();
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(9, label3);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitVarInsn(ISTORE, 3);
            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLineNumber(10, label4);
            Label label5 = new Label();
            methodVisitor.visitJumpInsn(GOTO, label5);
            Label label6 = new Label();
            methodVisitor.visitLabel(label6);
            methodVisitor.visitLineNumber(11, label6);
            methodVisitor.visitFrame(Opcodes.F_APPEND,3, new Object[] {"java/util/Scanner", Opcodes.INTEGER, Opcodes.INTEGER}, 0, null);
            methodVisitor.visitVarInsn(ILOAD, 3);
            methodVisitor.visitVarInsn(ILOAD, 2);
            methodVisitor.visitInsn(IADD);
            methodVisitor.visitVarInsn(ISTORE, 3);
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(10, label5);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitVarInsn(ILOAD, 3);
            methodVisitor.visitIntInsn(BIPUSH, 25);
            methodVisitor.visitJumpInsn(IF_ICMPLT, label6);
            Label label7 = new Label();
            methodVisitor.visitLabel(label7);
            methodVisitor.visitLineNumber(13, label7);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(ILOAD, 3);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            Label label8 = new Label();
            methodVisitor.visitLabel(label8);
            methodVisitor.visitLineNumber(14, label8);
            methodVisitor.visitInsn(RETURN);
            Label label9 = new Label();
            methodVisitor.visitLabel(label9);
            methodVisitor.visitLocalVariable("args", "[Ljava/lang/String;", null, label0, label9, 0);
            methodVisitor.visitLocalVariable("in", "Ljava/util/Scanner;", null, label1, label9, 1);
            methodVisitor.visitLocalVariable("input", "I", null, label3, label9, 2);
            methodVisitor.visitLocalVariable("accumulator", "I", null, label4, label9, 3);
            methodVisitor.visitMaxs(3, 4);
            methodVisitor.visitEnd();
		}
		
		//save bytecode into disk
		FileOutputStream out=new FileOutputStream("../bin/Acc.class");
		out.write(cw.toByteArray());
		out.close();

	}//end main

}//end class

