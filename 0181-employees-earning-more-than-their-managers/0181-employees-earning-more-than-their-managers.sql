# Write your MySQL query statement below
SELECT e1.name As Employee
from Employee e1
join Employee e2
on e1.managerId = e2.Id
where e1.salary > e2.salary