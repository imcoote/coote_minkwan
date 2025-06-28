SELECT
    CASE 
        WHEN g.grade >= 8 THEN s.name 
        ELSE 'NULL'
    END AS Name,---
    g.grade AS Grade,
    s.marks AS Mark
FROM students s JOIN grades g ON s.marks BETWEEN g.min_mark ANFD g.max_mark
ORDER BY
    g.grade DESC,
    CASE WHEN g.grade >= 8 THEN s.name END ASC,
    CASE WHEN g.grade < 8 THEN s.marks END ASC;
