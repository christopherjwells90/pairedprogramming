-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
INSERT INTO city (name, district, countrycode, population)
    VALUES ('Smallville', 'Kansas', 'USA', 45001);
SELECT *
FROM city
WHERE name = 'Smallville';
-- ROLLBACK;


-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
    VALUES ('USA', 'Kryptonese', false, .0001);
    
SELECT * 
FROM countrylanguage
WHERE language = 'Kryptonese';


-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
UPDATE countrylanguage
    SET language = 'Krypto-babble'
    WHERE language = 'Kryptonese';

SELECT * 
FROM countrylanguage
WHERE countrycode = 'USA';

-- 4. Set the US capital to Smallville, Kansas in the country table.
UPDATE country
SET Capital = (
    SELECT id 
    FROM city
    WHERE name = 'Smallville'
)
WHERE code = 'USA';

SELECT city.name
FROM city
JOIN country ON city.id = country.capital
WHERE country.code = 'USA';


-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
-- START TRANSACTION;
-- Delete
-- FROM city
-- Where name = 'Smallville' AND district = 'Kansas';
-- ROLLBACK;
-- VIOLATES FORIEGN KEY CONSTRAINT

-- 6. Return the US capital to Washington.
UPDATE country
SET Capital = (
    SELECT id 
    FROM city
    WHERE name = 'Washington' and district ILIKE '%DIST%'
)
WHERE code = 'USA';

SELECT city.name
FROM city
JOIN country ON city.id = country.capital
WHERE country.code = 'USA';

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

Delete
FROM city
Where name = 'Smallville' AND district = 'Kansas';
--Works because we removed the foriegn key connection

SELECT name
FROM city
WHERE name = 'Smallville' and district = 'Kansas';

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
UPDATE countrylanguage
SET isofficial = NOT isofficial
WHERE countrycode IN (
    SELECT code
    FROM country
    WHERE indepyear > 1800 AND indepyear < 1972
);

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)

UPDATE city
    SET population = (population::numeric/1000)::integer;

START TRANSACTION;
SELECT population
FROM city;


-- 10. Assuming a country's surfacearea is expressed in square miles, convert it to 
-- square meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
WITH french_speaking_countries AS (
        SELECT countrycode
        FROM countrylanguage
        WHERE language = 'French' AND percentage > 20
)
UPDATE country
sET surfacearea = surfacearea * 2.59*10^6
WHERE code IN (
    SELECT countrycode FROM french_speaking_countries
);