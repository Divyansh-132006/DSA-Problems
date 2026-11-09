# Write your MySQL query statement below
select Person.firstName, person.lastname, Address.city, Address.state
from person
left join Address
on person.personid = address.personid;