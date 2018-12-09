package tec;

public abstract class PassagerAbstrait implements Usager, Passager{

	private String nom;
	protected int destination;
	protected EtatPassager etat;
	
	public PassagerAbstrait(String nom, int destination) throws IllegalArgumentException{
		if(destination <= 0 ) {
			throw new IllegalArgumentException("Votre destination doit être supérieure à 0");
		}
		this.nom = nom;
		this.destination = destination;
		this.etat = new EtatPassager(EtatPassager.Etat.DEHORS);
	}
	
	
	/**
	   * Retourne vrai si l'etat du passager est exérieur
	   * @return vrai si l'etat  du passager est Dehors
	   */
	@Override
	final public boolean estDehors() {
		return (this.etat.estExterieur()); 
	}

	/**
	   * Retourne vrai si l'etat du passager est assis
	   * @return vrai si l'etat  du passager est assis
	   */
	@Override
	final public boolean estAssis() {
		return (this.etat.estAssis());
	}

	/**
	   * Retourne vrai si  l'etat du passager est Debout
	   * @return vrai si l'etat  du passager est Debout
	   */
	@Override
	final public boolean estDebout() {
		return (this.etat.estDebout());
	}



	/**
	   * Change l'état du passager en dehors
	   * Le passager est dehors
	   */
	@Override
	final public void accepterSortie() throws IllegalStateException{
		if(this.etat.monEtat == EtatPassager.Etat.DEHORS) {
			throw new IllegalStateException("Ce passager est déjà dehors!");
		}
		this.etat.monEtat = EtatPassager.Etat.DEHORS;
		
	}

	/**
	   * Change l'état du passager en assis
	   * Le passager est assis dans le bus
	   */
	@Override
	final public void accepterPlaceAssise() throws IllegalStateException {
		if(this.etat.monEtat == EtatPassager.Etat.ASSIS) {
			throw new IllegalStateException("Ce passager est déjà assis!");
		}
		this.etat.monEtat = EtatPassager.Etat.ASSIS;
		
	}

	/**
	   * Change l'état du passager en debout
	   * Le passager est debout dans le bus
	   */
	@Override
	final public void accepterPlaceDebout()  throws IllegalStateException{
		if(this.etat.monEtat == EtatPassager.Etat.DEBOUT) {
			throw new IllegalStateException("Ce passager est déjà debout!");
		}
		this.etat.monEtat = EtatPassager.Etat.DEBOUT;
		
	}

	public int getDest() {
		return this.destination;
	}

	/**
	   * Retourne le nom du passager
	   * @return nom
	   */
	@Override
	final public String nom() {
		return this.nom;
	}
	
	
	
	@Override
	  final public String toString() {
	    return this.nom + " " + this.etat.monEtat;
	  }

	protected abstract void choixPlaceMontee(Bus b) throws UsagerInvalideException;
	
	protected abstract void choixChangerPlace(Bus b,int arret) throws UsagerInvalideException;
	
	@Override
	final public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException{
		choixChangerPlace(bus, numeroArret);
	}

	@Override
	final public void monterDans(Bus bus) throws UsagerInvalideException{
		choixPlaceMontee(bus);
	}

}
