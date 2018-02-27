package model.items;

public enum Sauce {
	BEARNAISE{
		@Override
		public String toString() {
			return "Béarnaise";
		}
	},
	NATUUR{
		@Override
		public String toString() {
			return "Natuur";
		}
	},
	STROGANOFF{
		@Override
		public String toString() {
			return "Stroganoff";
		}
	},
	PROVENCAAL{
		@Override
		public String toString() {
			return "Provencaal";
		}
	},
	APPELMOES{
		@Override
		public String toString() {
			return "Appelmoes";
		}
	}
}
