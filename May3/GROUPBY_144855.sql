SELECT A.CATEGORY,SUM(SALES) AS TOTAL_SALES
FROM BOOK A LEFT JOIN BOOK_SALES B USING(BOOK_ID)
WHERE TO_CHAR(B.SALES_DATE,'YYYYMM') = '202201'
GROUP BY CATEGORY
ORDER BY CATEGORY