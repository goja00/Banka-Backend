------banka--------

INSERT INTO public.banka ("id","kontakt","naziv","pib")VALUES(nextval('banka_seq'), '(381)11 222-6000, 222-6713','ADDIKO BANK AD BEOGRAD',100228215);
INSERT INTO public.banka ("id","kontakt","naziv","pib")VALUES(nextval('banka_seq'), '(381)011/202-9050','AGROINDUSTRIJSKO KOMERCIJALNA BANKA AIK BANKA AKCIONARSKO DRUŠTVO, BEOGRAD',100618836);
INSERT INTO public.banka ("id","kontakt","naziv","pib")VALUES(nextval('banka_seq'), '(381) 011/2205-500','ALTA BANKA AD BEOGRAD',100001829);
INSERT INTO public.banka ("id","kontakt","naziv","pib")VALUES(nextval('banka_seq'), '(381) 011/3952-213','API BANK AKCIONARSKO DRUŠTVO BEOGRAD',105701111);
INSERT INTO public.banka ("id","kontakt","naziv","pib")VALUES(nextval('banka_seq'), '(381) 011/2011-200','BANCA INTESA AKCIONARSKO DRUŠTVO BEOGRAD (NOVI BEOGRAD)',100001159);
INSERT INTO public.banka ("id","kontakt","naziv","pib")VALUES(nextval('banka_seq'), '(381) 011/2020-292','BANKA POŠTANSKA ŠTEDIONICA AKCIONARSKO DRUŠTVO, BEOGRAD (PALILULA)',100002549);
INSERT INTO public.banka ("id","kontakt","naziv","pib")VALUES(nextval('banka_seq'), '(381)011/6351-000','BANK OF CHINA SRBIJA AKCIONARSKO DRUŠTVO BEOGRAD - NOVI BEOGRAD',109837136);
INSERT INTO public.banka ("id","kontakt","naziv","pib")VALUES(nextval('banka_seq'), '0800/201-201','ERSTE BANK AKCIONARSKO DRUŠTVO, NOVI SAD',101626723);
INSERT INTO public.banka ("id","kontakt","naziv","pib")VALUES(nextval('banka_seq'), '0800/111-144','EUROBANK DIREKTNA AKCIONARSKO DRUŠTVO BEOGRAD',100002532);

---------filijala--------------

insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Milutina Milankovića 7v, Beograd,',5,False,1);
insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Bulevar Mihaila Pupina 115 đ,Beograd.',16,False,2);
insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Bulevar Zorana Đinđića 121, Beograd.',7,True,3);
insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Bulevar vojvode Bojovića 6-8, Beograd.',9,False,4);
insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Milentija Popovića 7b, Beograd,',10,False,5);
insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Kraljice Marije 3, Beograd.',3,True,6);
insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Bulevar Zorana Đinđića 2a, Beograd,',11,True,7);
insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Dalmatinska 22, Beograd.',4,True,8);
insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Bulevar oslobođenja 5, Novi Sad.',3,True,9);
insert into public.filijala ("id","adresa","broj_pultova","poseduje_sef","banka")values(nextval('filijala_seq'),'Vuka Karadžića 10 Beograd.',2,False,9);


------korisnik_usluge------

insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Gojko','12344532332','Grubisic');
insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Andrija','12344532332','Milosevic');
insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Teodora','12344532332','Dzehverovic');
insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Vlatko','12344532332','Jakic');
insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Petar','12344532332','Maras');
insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Slobodan','12344532332','Ostojic');
insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Andjelka','12344532332','Prpic');
insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Masa','12344532332','Filipovic');
insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Milica','12344532332','Dabovic');
insert into public.korisnik_usluge ("id","ime","maticni_broj","prezime")values(nextval('korisnik_usluge_seq'),'Isidora','12344532332','Sekulic');


------usluga------

insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'Platne usluge','Otvaranjem računa i obavljanjem platnog prometa posredstvom naše banke, birate:Brzo i pouzdano sprovođenje platnih naloga','2022-04-12',0.2,1,1);
insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'Otvaranje poslovnog racuna','Ukoliko želite da otvorite poslovni račun za svoje preduzeće, učinite to kod nas brzo i jednostavno','2022-01-01',0.1,2,2);
insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'Debitne i kreditne kartice','Poslovne i debitne kartice,Svaka poslovna platna kartica iz naše ponude osmišljena je dizajnerski i funkcionalno da pojednostavi svakodnevno poslovanje vašeg preduzeća','2022-02-12',0.12,3,3);
insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'E banking','Elektronsko bankarstvo Vam omogućava pristup Raiffeisen banci sa računara ili telefona. ','2022-02-09',0.2345,4,4);
insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'M-banking','Uz mobilnu aplikaciju Moja mBanka koristite bankovne usluge svakodnevno na udoban i bezbedan način, pristupajte računima i plaćajte bez provizije','2022-05-25',0.1345,5,5);
insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'Mobilni keš','Usluga kroz koju je omogućeno slanje novca bilo kome i bilo kada','2022-11-12',0.321,6,6);
insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'"Prenesi" plaćanje','Potreban Vam je samo broj nečijeg mobilnog telefona da biste mu uplatili novac','2022-04-17',0.125,7,7);
insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'RaiPay','Za šoping ti je potrebna samo RaiPay aplikacija Raiffeisen banke.','2023-04-12',0.12,8,8);
insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'Apple Pay','Apple Pay je stigao! Sigurno i beskontaktno plaćanje uz Visa kartice Raiffeisen banke.','2022-06-21',0.41,9,9);
insert into public.usluga ("id","naziv","opis_usluge","datum_ugovora","provizija","filijala","korisnik_usluge") values(nextval('usluga_seq'),'Garmin Pay','Raiffeisen banka Vam donosi brza, jednostavna i beskontaktna plaćanja pomoću Vašeg Garmin sata.','2022-08-13',0.054,9,9);






