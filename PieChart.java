import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

class PieChart extends Frame {
	PieChart() {
		this.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent we ) {
				System.exit( 0 );
			}
		});
		this.setVisible( true );
		this.setSize( 400, 500 );
		this.add( new PieCanvas() );
	}

	class PieCanvas extends Canvas {
		float nmbrs[] = { 10f, 20f, 30f, 40f };
		String colors[] = { "magenta", "orange", "blue", "green" };
		float totalNmbr = 0f;
		float startAngle=0f, arcAngle=0f;
		float margin=20f;
		float pieHeight = 400-2*margin, pieWidth=400-2*margin;
			
		PieCanvas() {
			this.setSize( 400, 400 );
			for(float nmbr: nmbrs ) totalNmbr += nmbr;
		}

		public void paint( Graphics g ) {
			try {
				for( int i=0; i<nmbrs.length; i++ ) {
					Field f = Class.forName( "java.awt.Color" ).getField( colors[i] );
					g.setColor( (Color)f.get( null ) );
					arcAngle = 360f * ( nmbrs[i] / totalNmbr ); 
					g.fillArc( (int)margin, (int)margin, (int)pieWidth, (int)pieHeight, (int)startAngle, (int)arcAngle );
					startAngle += arcAngle;
				}
			} catch( Exception e ) {
				e.printStackTrace();
			}
		}
	}

	public static void main( String args[] ) throws Exception {
		new PieChart();
	}
}

