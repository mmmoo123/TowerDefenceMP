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
		default:
			break;
		}
		
		return imageIcon;
	}
}
