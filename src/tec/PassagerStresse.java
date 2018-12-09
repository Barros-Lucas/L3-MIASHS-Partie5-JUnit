package tec;

public class PassagerStresse extends PassagerAbstrait{

	public PassagerStresse(String nom, int destination) throws IllegalArgumentException {
		super(nom, destination);
	}
	
	public PassagerStresse(int destination) throws IllegalArgumentException {
		super("PassagerStresse"+destination, destination);
	}


	@Override

	public void choixChangerPlace(Bus b, int numeroArret) throws UsagerInvalideException {

		if(this.destination == numeroArret) {
			b.demanderSortie(this);
		}else if(this.destination <= numeroArret + 3) {

			b.demanderChangerEnDebout(this);

		}

	
	}
	@Override

	public void choixPlaceMontee(Bus b) throws UsagerInvalideException {

		if(b.aPlaceAssise()) {

			b.demanderPlaceAssise(this);

		}

	}

}

