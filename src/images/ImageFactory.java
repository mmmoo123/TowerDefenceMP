package images;

import javax.swing.ImageIcon;

import stale.Constants;

public class ImageFactory {
	public static ImageIcon createImage(Image image) {
		ImageIcon imageIcon = null;
		
		switch(image) {
		case MAPA:
			imageIcon = new ImageIcon(Constants.MAPA_IMAGE_URL);
			break;
		case IKONA:
			imageIcon = new ImageIcon(Constants.IKONA_IMAGE_URL);
			break;
		case B1:
			imageIcon = new ImageIcon(Constants.PRZECIWNIK_IMAGE_URL);
			break;
		case B2:
			imageIcon = new ImageIcon(Constants.SZYKI_PRZECIWNIK_IMAGE_URL);
			break;
		case B3:
			imageIcon = new ImageIcon(Constants.WOLNY_PRZECIWNIK_IMAGE_URL);
			break;
		case T1:
			imageIcon = new ImageIcon(Constants.SZYBKA_WIEZYCZKA_IMAGE_URL);
			break;
		case T2:
			imageIcon = new ImageIcon(Constants.WOLNA_WIEZYCZKA_IMAGE_URL);
			break;
		case T3:
			imageIcon = new ImageIcon(Constants.OBASZAROWA_WIEZYCZKA_IMAGE_URL);
			break;
		case YouLose:
			imageIcon = new ImageIcon(Constants.YOULOSE_IMAGE_URL);
			break;
		case InterfaceBackground:
			imageIcon = new ImageIcon(Constants.INTERFACEBACKGROUND_IMAGE_URL);
			break;

		default:
			break;
		}
		
		return imageIcon;
	}
}
