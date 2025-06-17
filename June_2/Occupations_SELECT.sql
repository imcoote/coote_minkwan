SELECT
    MAX(CASE WHEN Occupation = 'Doctor' THEN Name ELSE NULL END) AS Doctor,
    MAX(CASE WHEN Occupation = 'Professor' THEN Name ELSE NULL END) AS Professor,
    MAX(CASE WHEN Occupation = 'Singer' THEN Name ELSE NULL END) AS Singer,
    MAX(CASE WHEN Occupation = 'Actor' THEN Name ELSE NULL END) AS Actor
FROM (SELECT Name, Occupation, ROW_NUMBER() OVER (PARTITION BY Occupation ORDER BY Name) as rank
    FROM OCCUPATIONS
) RankedOccupations
--ROW_NUMBER(): 번호 매기기, OVER: 어떤 규칙으로, PARTITION BY Occupation: 직업 컬럼으로 나누고
GROUP BY rank
ORDER BY rank;