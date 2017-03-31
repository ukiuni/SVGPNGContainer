import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Public domain, no warranty at all.
 */
public class SVGPng64Container {
	public static final Pattern regex = Pattern.compile("xlink:href=\"([^\"]*)\"");

	private SVGPng64Container() {
	}

	public static String replaceXRefToBase64(String svg, File baseDir) throws FileNotFoundException, IOException {
		StringBuffer result = new StringBuffer();
		Matcher matcher = regex.matcher(svg);
		while (matcher.find()) {
			File pngFile = new File(baseDir, matcher.group(1));
			String pngBase64 = fileToBase64(pngFile);
			StringBuilder replacement = new StringBuilder().append("xlink:href=\"data:image/png;base64,").append(pngBase64).append("\"");
			matcher.appendReplacement(result, replacement.toString());
		}
		matcher.appendTail(result);
		return result.toString();

	}

	public static String fileToBase64(File pngFile) throws FileNotFoundException, IOException {
		try (FileInputStream in = new FileInputStream(pngFile)) {
			byte[] pngBytes = new byte[(int) pngFile.length()];
			return Base64.getEncoder().encodeToString(pngBytes);
		}
	}
}
