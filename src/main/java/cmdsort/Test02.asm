
Classfile /Users/chenyutao/GitHubProjects/Temp01/target/classes/cmdsort/Test02.class
  Last modified 2021年11月8日; size 560 bytes
  SHA-256 checksum 479d47c8912786d6005332a2d7e7d08969ba2ff29d59a1a763c8e4fc7881dfe5
  Compiled from "Test02.java"
public class cmdsort.Test02
  minor version: 0
  major version: 55
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #13                         // cmdsort/Test02
  super_class: #2                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 2, attributes: 3
Constant pool:
   #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
   #2 = Class              #4             // java/lang/Object
   #3 = NameAndType        #5:#6          // "<init>":()V
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Class              #8             // cmdsort/Test02$Student
   #8 = Utf8               cmdsort/Test02$Student
   #9 = Methodref          #7.#3          // cmdsort/Test02$Student."<init>":()V
  #10 = Methodref          #7.#11         // cmdsort/Test02$Student.study:()V
  #11 = NameAndType        #12:#6         // study:()V
  #12 = Utf8               study
  #13 = Class              #14            // cmdsort/Test02
  #14 = Utf8               cmdsort/Test02
  #15 = Utf8               Code
  #16 = Utf8               LineNumberTable
  #17 = Utf8               LocalVariableTable
  #18 = Utf8               this
  #19 = Utf8               Lcmdsort/Test02;
  #20 = Utf8               main
  #21 = Utf8               ([Ljava/lang/String;)V
  #22 = Utf8               args
  #23 = Utf8               [Ljava/lang/String;
  #24 = Utf8               student
  #25 = Utf8               Lcmdsort/Test02$Student;
  #26 = Utf8               SourceFile
  #27 = Utf8               Test02.java
  #28 = Utf8               NestMembers
  #29 = Utf8               InnerClasses
  #30 = Utf8               Student
{
  public cmdsort.Test02();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcmdsort/Test02;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #7                  // class cmdsort/Test02$Student
         3: dup
         4: invokespecial #9                  // Method cmdsort/Test02$Student."<init>":()V
         7: astore_1
         8: aload_1
         9: invokevirtual #10                 // Method cmdsort/Test02$Student.study:()V
        12: return
      LineNumberTable:
        line 9: 0
        line 10: 8
        line 11: 12
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      13     0  args   [Ljava/lang/String;
            8       5     1 student   Lcmdsort/Test02$Student;
}
SourceFile: "Test02.java"
NestMembers:
  cmdsort/Test02$Student
InnerClasses:
  static #30= #7 of #13;                  // Student=class cmdsort/Test02$Student of class cmdsort/Test02
