# Write your MySQL query statement below
Select c1.name AS Customers from Customers c1
left join Orders o1 on c1.id=o1.customerId 
where o1.customerId is Null;