-- SELECT * FROM student;
-- SELECT * from student WHERE status = 1;
-- SELECT * FROM subject WHERE credit < 10;
-- SELECT 
--     student.studentID,
--     student.studentName,
--     class.classID,
--     class.className
-- FROM
--     student
--         INNER JOIN
--     class ON student.classID = class.classID
-- WHERE
--     class.className = 'A1';
    
-- SELECT 
--     student.studentID,
--     student.studentName,
--     subject.subname,
--     mark.mark
-- FROM
--     student
--         INNER JOIN
--     mark ON student.studentID = mark.studentID
--         INNER JOIN
--     subject ON subject.subjectID = mark.subjectID
-- WHERE
--     subject.subname = 'CF';
    
-- SELECT 
--     *
-- FROM
--     mark;
-- SELECT 
--     *
-- FROM
--     subject;