package lessonone;

public class Id {
	
	/**
	 *	Klasa eshte immutable. Klase qe krijon objekt qe nuk ndryshon.
	 *	Vlerat e atributeve mbeten gjithe kohen njesoj me vleren fillestare
	 *	qe ju jepet.
	 *	Te gjitha klasat immutable respektojne rregullat vijues:
	 *
	 *	1. atributet i deklarojne private
	 *	2. nuk ndertohen metoda qe ndryshojne atributet (metoda setter)
	 *	3. metodat getter ndertohen me tip qe nuk lejon modifikimin e 
	 *	   te dhenave 
	 *	4. parametrat e konstruktoreve "klonohen" nqs jane te ndryshushem
	 *		pra, nuk ruhet objekti qe vjen, por nje kopje e tij
	 *	5. metodat ndertohen te pandryshushme (final, qe nuk ju behet override)
	 **/
	
	/***
	 *	Skema qe perdor kjo klase eshte bazike.
	 *	Gjenerohet id si nje numer i plote.
	 *	Fillimisht gjenerohet id me vlere 1.
	 *	Kur kerkohet id e radhes, jepet vlera 2,
	 *	e keshtu me radhe.
	 *	Klasa mund te gjeneroje 2^63 - 1 vlera.
	 *	KJO klase nuk lejon qe te ndryshoje permbajtja e nje objekti
	 *	te krijuar me pare.
	 **/
	
	private long value;
	/***
	 *	ne nje klase, atribute jane ato variabla qe
	 *	deklarohen ne trupin e klases
	 *
	 * 	atributet sherbejne per te ruajtur te dhena
	 * 	per objektet qe krijohen me ane te kesaj klase
	 * 
	 * 	atributet ruajne vleren default te tipit me te
	 * 	cilin jane deklaruar deri kur atyre
	 * 	ju jepet vlere tjeter
	 * 
	 * 	atributeve, ashtu si cdo antari tjeter te klases
	 * 	i percaktohet edhe access modifier
	 * 
	 * 	nqs nuk percaktohet nje i tille, atehere ne menyre
	 * 	te paracaktuar percaktohet access modifier-i
	 * 	package private / public by default
	 * 
	 * 	antari eshte i aksesushem brenda klases si dhe
	 * 	ne klasat e tjera te te njejtes pakete ku ndodhet
	 * 	kjo klase
	 * 
	 * 	access modifier ndryshohet ne private nqs vlera
	 * 	cenohet ne perdorim (kur nuk garantohet ruajtja
	 * 	e integritetit/saktesise)
	 * 
	 * access modifier private lejon qe antari i klases
	 * te perdoret vetem brenda klases
	 * 
	 * kur nje atribut nuk eshte me i perdorshem jasht klases
	 * sepse access modifier i tij eshte private, zakonisht
	 * krijohet metode qe lejon perdorim te atributit ne nje
	 * forme qe nuk e cenon saktesine e tij (metoda te lejon
	 * te perdoresh vleren e ruajtur ne atribut, por jo ta
	 * ndryshosh ate)
	 **/

	private static long nextValue = 1;
	/****
	 *	atributet static ruhen ne kujtese vetem nje here,
	 *	pavaresisht sa objekte krijon klasa
	 *
	 *	ndersa atributet jo static vendosen ne kujtese
	 *	per cdo objekt te krijuar
	 */
	
	public long getValue() {
		return value;
	}
	
	/**
	 *	Atributet vlerat fillestare i marrin
	 *	ne trupin e konstruktorit. Nese nje atribut
	 *	nuk specifikohet ne trupin e konstruktorit
	 *	atehere ai mbetet me vleren default te tipit me
	 *	te cilin eshte deklaruar. 
	 **/
	
	public Id() {
		//value = randomValue(1, Long.MAX_VALUE);
		//sipas skemes se sugjeruar, vlerat gjenerohen gjithmone
		//ne kete menyre nuk e parashikojme sa eshte id e radhes
		//problem i mundshem eshte qe mund te gjenerohet dy her
		//e njejta id
		//per te mos lejuar gjenerimin e dy id te njejta, do verifikojme
		//nese id e sapogjeneruar eshte gjeneruar me pare
		//per kete arsye duhet te ruhen id e te gjithe objekteve te
		//klases qe jane krijuar me heret
		//si mund te ruajme ne klasen tone t gjitha vlerat e id te 
		//krijuara me pare?
		//do perdoret nje liste
		//lista e ka madhesine maksimale 2^31-1 vlera
		//e pamundur per tja dal per skemen tone
		//mund te perdoren disa lista, te ruajtur ne nje liste
		//to be continued (mesimi 3)
		value = nextValue;
		nextValue = nextValue + 1;
	}
	
	/**
	 *	Konstruktori eshte nje metode qe:
	 *
	 *	1. ka emer te njejte me emrin e klases
	 *	2. nuk ka tip kthimi
	 *	3. nuk kthen vlere
	 *	4. vendos vlerat fillestare per atributet
	 **/

}
