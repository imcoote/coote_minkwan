SELECT MAX(salary * months) AS max_earnings, COUNT(*) AS employee_count
FROM Employee
WHERE (salary * months) = (SELECT MAX(salary * months) FROM Employee);