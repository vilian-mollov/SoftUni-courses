USE gringotts;

-- Select all deposit groups and its total deposit sum. Sort result by total_sum in increasing order.

SELECT deposit_group, SUM(deposit_amount) AS total_sum FROM wizzard_deposits
GROUP By deposit_group
order by total_sum;
