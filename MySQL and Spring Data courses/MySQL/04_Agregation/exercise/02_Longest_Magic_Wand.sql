USE gringotts;

-- Select the size of the longest magic wand. Rename the new column appropriately.

SELECT MAX(magic_wand_size) AS longest_magic_wand
FROM wizzard_deposits;
