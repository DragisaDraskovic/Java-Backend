INSERT INTO "liga"("id","naziv","oznaka")
VALUES(nextval('liga_seq'), 'Ling Long Super Liga','Superliga');
INSERT INTO "liga"("id","naziv","oznaka")
VALUES(nextval('liga_seq'),'Bundes Liga','GER');
INSERT INTO "liga"("id","naziv","oznaka")
VALUES(nextval('liga_seq'),'Liga 1','LFP');
INSERT INTO "liga"("id","naziv","oznaka")
VALUES(nextval('liga_seq'),'Liga MX', 'MX');
INSERT INTO "liga"("id","naziv","oznaka")
VALUES(nextval('liga_seq'),'La Liga','LaLiga');
INSERT INTO "liga"("id","naziv","oznaka")
VALUES(nextval('liga_seq'),'J1 Liga','J1');
INSERT INTO "liga"("id","naziv","oznaka")
VALUES(nextval('liga_seq'),'Premier Liga','EFL');
INSERT INTO "liga"("id","naziv","oznaka")
VALUES(nextval('liga_seq'),'Belgiska prva divizia A','BFL');
	   
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'), 'Srbija','SRB'); 
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'),'Nemacka','DEU');
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'),'Francuska','FRA');
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'),'Meksiko','MEX');
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'),'Japan','JPN');
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'),'Rusija','RUS');
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'),'Maroko','MAR');
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'),'Belgija','BEL');
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'),'Engleska','ENG');
INSERT INTO "nacionalnost" ("id", "naziv", "skracenica")
VALUES(nextval('nacionalnost_seq'),'Argentina','ARG');

INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Partizan',to_date('04.10.1945','dd.mm.yyyy'),'Beograd',1);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'FC Barselona',to_date('29.11.1899','dd.mm.yyyy'),'Barselona',5);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Crvena Zvezda',to_date('04.03.1945','dd.mm.yyyy'),'Beograd',1);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Real Madrid',to_date('06.03.1902','dd.mm.yyyy'),'Madrid',5);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Tigrovi UANL',to_date('07.03.1960','dd.mm.yyyy'),'San Nikolas de los Garsa',4);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Cruz Azul', to_date('22.05.1927','dd.mm.yyyy'),'Meksiko Siti', 4);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Bajern Minhen', to_date('27.02.1900','dd.mm.yyyy'),'Minhen',2);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Borusija Dortmund', to_date('12.12.1909','dd.mm.yyyy'),'Dortmund',2);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Pariz sen Zermen', to_date('12.08.1970','dd.mm.yyyy'),'Pariz', 3);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Celsi',to_date('10.03.1905','dd.mm.yyyy'),'London',7);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Nica',to_date('09.07.1904','dd.mm.yyyy'),'Nica',3);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Arsenal',to_date('10.1886','mm.yyyy'),'London',7);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Cerezo Osaka',to_date('1957','yyyy'),'Osaka',6);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Jokohoma',to_date('1999','yyyy'),'Yokohoma', 6);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Anderleht',to_date('27.05.1908','dd.mm.yyyy.'),'Anderleht',8);
INSERT INTO "tim" ("id","naziv","osnovan","sediste","liga")
VALUES(nextval('tim_seq'),'Gent',to_date('1864','yyyy'),'Gent',8);
 
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Filip','Stevanovic','231',to_date('25.09.2002','dd.mm.yyyy'),1,1);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Vladimir','Stojkovic','123',to_date('29.07.1983','dd.mm.yyyy'),1,1);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Milan','Pavkov','9921',to_date('09.02.1994','dd.mm.yyyy'),1,3);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Milan','Borjan','54321',to_date('23.09.1987','dd.mm.yyyy'),1,3);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Lionel','Messi','9982',to_date('24.06.1987','dd.mm.yyyy'),10,2);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Usman','Dembele','98213',to_date('15.05.1997','dd.mm.yyyy'),3,2);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Garet','Bejl','21456',to_date('16.07.1989','dd.mm.yyyy'),9,4);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Karim','Benzema','2345',to_date('19.12.1987','dd.mm.yyyy'),3,4);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Jirgen','Dam','1678',to_date('07.09.1992','dd.mm.yyyy'),4, 5);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Karlos','Salsedo','14263',to_date('29.09.1993','dd.mm.yyyy'),4,5);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Roberto','Alvardo','213408',to_date('07.09.1997','dd.mm.yyyy'),4,6);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Luis','Romo','205634',to_date('05.06.1995','dd.mm.yyyy'), 4, 6);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Zerom','Boateng','26574578',to_date('03.09.1988','dd.mm.yyyy'),2,7);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Tomas','Miler','532745',to_date('13.09.1987','dd.mm.yyyy'),2,7);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Dzejdon','Sanco','21323',to_date('25.03.2000','dd.mm.yyyy'),9,8);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Marko','Rojs','3249',to_date('31.05.1989','dd.mm.yyyy'), 2,8);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Angel','de Maria','7650',to_date('14.02.1988','dd.mm.yyyy'),10,9);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Kilijan','Mbape','9363',to_date('20.12.1998','dd.mm.yyyy'), 3,9);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Adam','Unas','94656',to_date('11.11.1996','dd.mm.yyyy'), 3,11);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Valter','Benitez','5639',to_date('19.03.1993','dd.mm.yyyy'), 3,11);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Tami','Abraham','38475',to_date('02.10.1997','dd.mm.yyyy'), 9,10);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Ros','Barkli','93847',to_date('05.12.1993','dd.mm.yyyy'), 9, 10);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Nikola','Pepe','8231',to_date('29.05.1995','dd.mm.yyyy'),3,12);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Bukayo','Saka','1562',to_date('05.09.2001','dd.mm.yyyy'),9,12);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Hirosi','Kijotake','52312',to_date('12.11.1989','dd.mm.yyyy'),5,13);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Yusuki','Kimoto','263564',to_date('06.08.1993','dd.mm.yyyy'), 5,13);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Sinosuke','Hatanaka','562',to_date('25.08.1995','dd.mm.yyyy'), 5,14);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Takuya','Kida','7123',to_date('23.08.1994','dd.mm.yyyy'),5,14);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Adrijen','Trebel','3426',to_date('03.03.1991','dd.mm.yyyy'),3,15);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Dejan','Joveljic','236',to_date('07.08.1999','dd.mm.yyyy'),1,15);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Sven','Kums','3453',to_date('26.02.1988','dd.mm.yyyy'),8,16);
INSERT INTO "igrac" ("id","ime","prezime","broj_reg","datum_rodjenja","nacionalnost","tim")
VALUES(nextval('igrac_seq'), 'Kolin','Kosemans','7342',to_date('03.08.1992','dd.mm.yyyy'),8,16);