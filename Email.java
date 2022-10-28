package lessonone;

import java.util.ArrayList;
import java.util.Objects;

public class Email {
	
	/***
	 *	Kjo klase mundeson ruajtjen e te dhenave per email.
	 *	Per cdo email ruhen dy te dhena, zona lokale dhe zona domain.
	 *	Per shembull, per email rigelsrajku@otr.al,
	 *					zona lokale eshte rigelsrajku
	 *					zona domain eshte otr.al
	 *	Kjo klase nuk lejon qe te krijohen dy here email-e te njejte.
	 *	Dmth nqs tentohet per here te dyte te krijohet nje email
	 *	me permbajtje rigelsrajku@otr.al, ath zona lokale modifikohet
	 *	duke i shtuar asaj nje numer ne fund, rigelsrajku1@otr.al. 
	 *	Per nje te trete krijohet rigelsrajku2@otr.al.
	 *	KJO klase nuk lejon qe te ndryshoje permbajtja e nje objekti
	 *	te krijuar me pare.
	 **/
	
	private String local;
	private String domain;

	private static final ArrayList<Email> emails = new ArrayList<Email>();
	
	public Email(String email) {
		//rigelsrajku@otr.al
		//rigelsrajku, otr.al
		if(email == null || (email = email.trim()).isEmpty()) {
			//duhet te ndalohet krijimi i objektit
			//ne nuk jemi akoma aq te zote
			//bejme zgjidhje me marreveshje
			email = "default@default";
		}
		int index = email.indexOf("@");
		if(index == -1) {
			email = email + "@default";
			index = email.indexOf("@");
		}
		else {
			//unejamotr@otr@otr.al
			if(email.indexOf("@", index + 1) != -1) {
				email = email.substring(0, index) + 
						email.substring(email.lastIndexOf("@")); 
			}
		}
		String local = email.substring(0, index).trim().toLowerCase();
		//Variablat qe i referohen te njejtes gje (si ide)
		//duhet te kene te njejtin emer.
		//Psh per zonen lokale atributi emertohet local.
		//Ne kodin e klases, sa here nje variabel ruan zonen lokale te 
		//nje email sugjerohet te emertohet po njesoj.
		//psh variabli localPart duhet emertuar local
		if(local.isEmpty()) {
			//duhet te ndalohet krijimi i objektit
			//ne nuk jemi akoma aq te zote
			//bejme zgjidhje me marreveshje
			local = "default";
		}
		String domainPart = email.substring(index + 1).trim().toLowerCase();
		if(domainPart.isEmpty()) {
			//duhet te ndalohet krijimi i objektit
			//ne nuk jemi akoma aq te zote
			//bejme zgjidhje me marreveshje
			domainPart = "default";
		}
		if(exist(local, domainPart)) {
			//duhet te ndalohet krijimi i objektit
			//ne nuk jemi akoma aq te zote
			//bejme zgjidhje me marreveshje
			local = getNextLocal(local, domainPart);
		}
		this.local = local;
		domain = domainPart;
		emails.add(this);
		//this eshte fjale kyce
		//i referohet objektit te klases
		//objekti qe po veron 
		//ne kete rast, objekti qe sapo u krijua nga konstruktori
		//perdoret gjithashtu per te referuar antaret jo static,
		//si dhe per te mundesuar therritje te nje konstruktori
		//ne trupin e nje konstruktori teter
		//therritja e nje kontruktori te te njejtes klase ne 
		//nje konstruktor tjeter te saj behet nepermjet instruksionit
		//this, duke e koduar ate si instruksion te pare ne trupin
		//e konstruktorit, shoqeruar me argumenta te vendosur ne ( )
		//sipas parametrave te konstruktorit qe therritet 
		//this perdoret per t referuar atributet ne rastet kur ne trupin
		//e metodes ka deklarim variabli me te njejtin emer si emri i
		//atributit
		//ne fakt kur deklarohet variabel qe emertohet njesoj me atributin
		//atibuti behet i padallushem (fshihet / hide)
		//per ta perdorur referohet nepermjet this si this.emerAtribut
	}
	
	public Email(String local, String domain) {
		this(local + "@" + domain);
//		//rigelsrajku, otr.al
//		if(localPart == null || (localPart = localPart.trim().toLowerCase()).isEmpty()) {
//			//duhet te ndalohet krijimi i objektit
//			//ne nuk jemi akoma aq te zote
//			//bejme zgjidhje me marreveshje
//			localPart = "default";
//		}
//		if(domainPart == null || (domainPart = domainPart.trim().toLowerCase()).isEmpty()) {
//			//duhet te ndalohet krijimi i objektit
//			//ne nuk jemi akoma aq te zote
//			//bejme zgjidhje me marreveshje
//			domainPart = "default";
//		}
//		if(exist(localPart, domainPart)) {
//			//duhet te ndalohet krijimi i objektit
//			//ne nuk jemi akoma aq te zote
//			//bejme zgjidhje me marreveshje
//			localPart = getNextLocalPart(localPart, domainPart);
//		}
//		local = localPart;
//		domain = domainPart;
//		emails.add(this);
	}
	
	/**
	 *	Ne zhvillimin e kodit ndertohen metoda, apo deklarohen
	 *	edhe antar te tjere qe mund te mos jene kerkuar. Meqe
	 *	keto antar nuk deshirohen ne perdorim ne vazhdim, ato
	 *	enkapsulohen, behen te padallushem/te paperdorshem
	 *	nga te tjeret. I perdorim vetem ne qe zhvillojme kodin.
	 *	Enkapsulimi nenkupton "fshehjen" e detajeve/mjeteve qe
	 *	jane perdorur dhe nuk jane kerkuar te zhvillohen/ndertohen. 
	 **/
	
	private static String getNextLocal(String local, 
									   String domain) {
		int number = 1;
		while(exist(local + number, domain)) {
			number++;
		}
		return local + number;
	}

	private static boolean exist(String lolcal, 
								 String domain) {
//		for(int i = 0; i < emails.size(); i++) {
//			if(emails.get(i).local.equals(localPart) &&
//			   emails.get(i).local.equals(domainPart)) {
//				return true;
//			}
//		}
		
		for(Email e : emails) {
			if(e.local.equals(lolcal) && e.domain.equals(domain)) {
				return true;
			}
		}
		return false;
	}
	
	public final String getEmail() {
		return local + "@" + domain;
	}
	
	public String getLocal() {
		return local;
	}
	
	public String getDomain() {
		return domain;
	}
	
	@Override
	public String toString() {
		return "lessonone.Email[local=" + local + ", domain=" + domain + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(domain, local);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Email)) {
			return false;
		}
		Email other = (Email) obj;
		return Objects.equals(domain, other.domain) && 
			   Objects.equals(local, other.local);
//		if(local == null) {
//			if(other.local != null) {
//				return false;
//			}
//		}
//		else if(other.local == null) {
//			return false;
//		}
//		else if(!local.equals(other.local)) {
//			return false;
//		}
//		if(domain == null) {
//			if(other.domain != null) {
//				return false;
//			}
//		}
//		else if(other.domain == null) {
//			return false;
//		}
//		else if(!domain.equals(other.domain)) {
//			return false;
//		}
//		return true;
	}
	
	
	
}
