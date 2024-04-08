

Following are the commands and the instructions to run ANT on project.
#### Note: build.xml is present in studentCoursesBackup/src folder.
#### Note: courseInfo.txt, coursePrefs.txt, errorLog.txt, regConflicts.txt, and regResults.txt to be placed in same directory level as src

Assumptions : Input files are well formatted, and no dupulicates

-----------------------------------------------------------------------
## How to clean ?

Command: ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when code was compiled.

-----------------------------------------------------------------------
## How to compile ?

Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## How to run ?

Command: ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=coursePrefs.txt -Darg1=courseInfo.txt -Darg2=regResults.txt -Darg3=regConflicts.txt -Darg4=errorLog.txt

-----------------------------------------------------------------------
## Sample Input 

#### coursePrefs.txt

111 D C A B G I H F G;<br/>
222 F E D C B A H I G;<br/>
333 D A F E I C H B G;<br/>

#### courseInfo.txt

A:30:1<br/>
B:40:2<br/>
C:50:3<br/>
D:60:1<br/>
E:70:7<br/>
F:35:4<br/>
G:45:3<br/>
H:55:7<br/>
I:25:6<br/>

## Output


#### regResults.txt

111:D,C,B::SatisfactionRating=7.67<br/>
222:F,E,D::SatisfactionRating=8.00<br/>
333:D,F,E::SatisfactionRating=7.33<br/>
...<br/>
AverageSatisfactionRating=7.67<br/>

#### regConflicts.txt

Clashing Courses: [A] with allocated course for Student ID 111<br/>
Clashing Courses: [A] with allocated course for Student ID 333<br/>

#### errorLog.txt



-----------------------------------------------------------------------


#### Choice of Data Structure 

Hash map is used to store the information related to course, 

A HashMap's insertion, deletion, and search operations typically require O(1) constant time. In the worst situation, searching, insertion, and deletion in Java take O(n) time. 

HashMap was my choice because to store the unique student id's and their courses, searching, updation operations with O(1) time. With increase in size, the hashmap space will increase. So, the space complexity for HashMap is O(n).

HashMaps have the benefit of having time complexity for inserting and retrieving values that is typically O(1) over list which is O(n).


-----------------------------------------------------------------------
## Description:

A Student Registration was developed using Java. The Input of this program is two .txt files coursePrefs.txt and courseInfo.txt which includes student nine course preferences (all are unique courses). courseInfo includes the different courses with seats availability and timing for the course. The algorithm that was followed was First come First Serve. From Course Info file, one by one student course preference will be captured and assign their requested courses on availability. If there are any clashes or seats unavailability their next preference of their course will be allocated. The result of their final allocated coursess will be stored in regResults.txt file it also includes satisfaction rating of the student after assigning the courses also average satisfaction rate of the students. If any conflicts between allocating course and already allocated course then the conflict was written in redConflicts.txt file. For any errors like file not found and others the errors will be written to errorLog.txt file. The code was written in Java and while reading input and output files used interfaces, handled exception handling, validated number of arguments, provided comments in Javadoc style for every class with return type explained and all the design formatting is followed while developing the code. 

-----------------------------------------------------------------------
## References:

1. https://www.geeksforgeeks.org/overriding-tostring-method-in-java/
2. https://www.geeksforgeeks.org/filewriter-class-in-java/

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 09/29/2022


