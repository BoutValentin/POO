package tp07;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import util.PieChart;
public class SuperPieChart {
	private PieChart diag;
	
	public SuperPieChart(String name, String[] nameKey, float[] value1, Color[] value2 ){
		Map<String, Float> m1 = new HashMap<String, Float>();
		Map<String, Color> m2 = new HashMap<String, Color>();
		for(int i = 0; i<nameKey.length ; i++) {
			m1.put(nameKey[i], (Float) value1[i]);
			m2.put(nameKey[i], value2[i]);
		}
		this.diag = new PieChart(name, m1, m2);
	}
	
	public SuperPieChart(String name, String[] nameKey, float[] value) {
		this(name, nameKey, value, SuperPieChart.darkerRed(nameKey.length));
	}
	private static Color[] darkerRed(int le) {
		Color[] value2 = new Color[le];
		value2[0] = Color.RED;
		for(int i = 1 ; i< value2.length; i++ ) {
			value2[i] = value2[i-1].darker(); 
		}
		return value2;
	}
	
	public boolean fillin(String[] nameKey, float[] value) {
		Map<String, Float> m = new HashMap<String, Float>();
		for(int i = 0; i<nameKey.length ; i++) m.put(nameKey[i], value[i]);
		return this.diag.fillIn(m);
	}
	
	public boolean color(String[] nameKey, Color[] value) {
		Map<String, Color> m = new HashMap<String, Color>();
		for(int i = 0; i<nameKey.length ; i++) m.put(nameKey[i], value[i]);
		return this.diag.color(m);
	}
	
	public boolean fading(HashMap<String, Float> values) {
		if(! this.diag.fillIn(values))return false;
		Color[] col = SuperPieChart.darkerRed(values.size());
		Map<String, Color> m = new HashMap<String, Color>();
		String[] key = new String[values.size()];
		int index = 0;
		for(Map.Entry<String, Float> e : values.entrySet()) {
			key[index]= e.getKey();
			index++;
		}
		for(int  i = 0; i<col.length; i++) m.put(key[i], col[i]);
		this.diag.color(m);
		return true;
	}
	
	public static void main(String[] args) {
		String[] key = new String[] {"un", "deux", "trois", "quatre"};
		float[] val = new float[] {(float) 1.2, (float) 1.2, (float) 7.8, (float) 88.8};
		Color[] color = new Color[] {Color.BLUE, Color.DARK_GRAY, Color.GREEN, Color.CYAN};
		SuperPieChart p = new SuperPieChart("andre", key, val, color);
		SuperPieChart p1 = new SuperPieChart("beber", key, val);
		HashMap<String, Float> m = new HashMap<String, Float>();
		m.put(key[0], (Float) val[0]);
		m.put(key[1], (Float) val[1]);
		m.put(key[2], (Float) val[2]);
		m.put(key[3], (Float) val[3]);
		p.fading(m);
	}
	
}
