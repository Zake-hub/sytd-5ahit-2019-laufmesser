/*JPA QUERIES

Für den übergebenen Branch alle Köche die dort arbeiten
Für ein Gericht alle Ingredients die drin sind
Für einen bestimmten Waiter die Tische die er managed
Für einen Tisch den Umsatz berechnen
Für einen Branch welcher Tisch den maximalen Umsatz hat
Welcher Branch den meisten Umsatz hat*/

//Normale SQL Query /*Geben Sie alle Köche eines bestimmten Branches aus die dort Arbeiten*/
SELECT Koch.Name
FROM Filiale
JOIN Filialen_Angestellten USING(Filialen_ID)
JOIN Koch USING(Angestellten_ID)
WHERE Filiale.Filialen_ID = ?;

//JPA Query
SELECT c
FROM Cook c
JOIN c.branchList bl
WHERE bl = :branch;
// oder
SELECT a
FROM AArbieter a
JOIN a.branchList lb
WHERE type(a) = cook AND b = :branch;


//Normale SQL Query /*Geben Sie alle Ingredients eines Gerichts aus*/
SELECT Ingredients.Name
FROM Gericht
JOIN Gericht_Zutat USING (Gericht_ID)
JOIN Ingredients USING (Zutat_ID)
WHERE Gerichts_ID = ?;

//JPA Querry
SELECT i
FROM Gericht d
JOIN d.gerichtZutatID.Zutat i
WHERE d.gerichtZutatID.gericht = :gericht;


//Normale SQL Query /*Alle Tische eines bestimmten Kellners*/
SELECT Kellner
FROM Kellner
JOIN Kellner_Tische USING (Kellner_ID)
JOIN Tische USING (Tische_ID)
WHERE Kellner.Kellner_ID = ?;

//JPA Query
SELECT t
FROM Waiter w
JOIN w.tableList t
WHERE w = :waiter


//Normale SQL Query /*Umsatz eines bestimmten Tisches*/
SELECT Sum(preis)
FROM Tisch
JOIN Bestellung_Tisch_Gericht USING (Tisch_ID)
JOIN Gericht USING (Gericht_ID)
GROUP BY Tisch_ID
HAVING Tisch_ID := ?;

//JPA Query
SELECT sum(d.dish.price)
FROM OrderTableDish o
JOIN OderTableDishID d
WHERE d.table = :table