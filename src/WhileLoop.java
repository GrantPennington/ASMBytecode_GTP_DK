import java.io.FileOutputStream;
import java.io.IOException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;

import static org.objectweb.asm.Opcodes.*;

public class WhileLoop {

	public static void main(String[] args) throws IOException{
		
		ClassWriter cw=new ClassWriter(0);
		cw.visit(V11, ACC_PUBLIC+ACC_SUPER, "whileLoop", null, "java/lang/Object", null);
	
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
            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, new String[] { "java/io/IOException" });
            mv.visitCode();
            Label label0 = new Label();
            mv.visitLabel(label0);
            mv.visitLineNumber(8, label0);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ISTORE, 1);
            Label label1 = new Label();
            mv.visitLabel(label1);
            mv.visitLineNumber(9, label1);
            Label label2 = new Label();
            mv.visitJumpInsn(GOTO, label2);
            Label label3 = new Label();
            mv.visitLabel(label3);
            mv.visitLineNumber(10, label3);
            mv.visitFrame(Opcodes.F_APPEND,1, new Object[] {Opcodes.INTEGER}, 0, null);
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(ILOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            Label label4 = new Label();
            mv.visitLabel(label4);
            mv.visitLineNumber(11, label4);
            mv.visitIincInsn(1, 1);
            mv.visitLabel(label2);
            mv.visitLineNumber(9, label2);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(ICONST_5);
            mv.visitJumpInsn(IF_ICMPLT, label3);
            Label label7 = new Label();
            mv.visitLabel(label7);
            mv.visitLineNumber(15, label7);
            mv.visitInsn(RETURN);
            Label label8 = new Label();
            mv.visitLabel(label8);
            mv.visitLocalVariable("args", "[Ljava/lang/String;", null, label0, label8, 0);
            mv.visitLocalVariable("i", "I", null, label1, label8, 1);
            mv.visitMaxs(8, 2);
            mv.visitEnd();
        
		
		//save bytecode into disk
		FileOutputStream out=new FileOutputStream("../bin/whileLoop.class");
		out.write(cw.toByteArray());
		out.close();

	}//end main

}//end class