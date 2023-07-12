package entities;

public class Revista extends ItemBibliografico {
		private int edicao;
		
		public Revista (String titulo, int anoPublicacao, int edicao) {
			super(titulo, anoPublicacao);
			
			this.edicao = edicao;
		}
		
		// Access methods
		public int getEdicao() {
			return edicao;
		}
		
		// Logic methods
		public <T> boolean equalsRevista(T obj) { // Comparar se os objetos são do tipo Revista
			
			if (obj instanceof Revista) {
				Revista varRevista = (Revista) obj;
				return this.edicao == varRevista.getEdicao(); // é == porque é um tipo primitivo. Tipo primitivo fica na stack da memória ram
			}
			return false;
			
		}
		
		@Override
		public String toString() {
			return super.getTitulo() + " - " + super.getAnoPublicacao() + " - " + this.edicao;
		}
		
}
