# Write your MySQL query statement below
SELECT firstName,lastName,city,state from person p
left Join Address a on p.personId=a.personId 
