package br.com.introcdc.tests.files;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class ImageCompresser {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("java ImageCompressor <input folder> <output folder>");
            return;
        }
        final File inputFolder = new File(args[0]);
        final File outputFolder = new File(args[1]);

        if (!inputFolder.isDirectory()) {
            System.out.println("A diretório de input não é válido.");
            return;
        }
        if (!outputFolder.isDirectory()) {
            System.out.println("A diretório de output não é válido.");
            return;
        }

        for (final File in : inputFolder.listFiles()) {
            final File out = new File(outputFolder, in.getName());
            final String[] dotted = in.getName().split("\\.");
            String extension = "";
			if (dotted.length > 1) {
				extension = dotted[dotted.length - 1].toLowerCase();
			}

			if (extension.equals("jpg") || extension.equals("jpeg")) {
				System.out.println(in.getName() + ": Comprimindo imagem...");
				compressJpeg(in, out);
			} else if (extension.equals("png")) {
				System.out.println(in.getName() + ": Convertendo e comprimindo imagem...");
				convertAndCompressPng(in, out);
			} else {
				System.out.println(in.getName() + ": Extensão não suportada! Copiando...");
				copy(in, out);
			}
		}
    }

	private static void compressJpeg(File in, File out) throws Exception {
		final BufferedImage image = ImageIO.read(in);
		if (image == null) {
			System.out.println(in + ": Falha ao carregar.");
			return;
		}
		writeCompressedJpeg(in.length(), image, out);
	}

	private static void convertAndCompressPng(final File in, final File out) throws IOException {
    	final BufferedImage image = ImageIO.read(in);
		if (image == null) {
			System.out.println(in + ": Falha ao carregar.");
			return;
		}

		BufferedImage noAlphaImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		final Graphics2D graphics = noAlphaImage.createGraphics();
		graphics.drawImage(image, 0, 0, Color.BLACK, null);
		graphics.dispose();

		writeCompressedJpeg(in.length(), noAlphaImage, out);
	}

	private static void writeCompressedJpeg(final long size, final BufferedImage image, final File out) throws IOException {
		final BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(out));

		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
		ImageWriter writer = writers.next();

		ImageOutputStream imageOutStream = ImageIO.createImageOutputStream(outStream);
		writer.setOutput(imageOutStream);

		ImageWriteParam param = writer.getDefaultWriteParam();
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);

		//param.setCompressionQuality(0.8f);
		if (size <= 50000) {
			param.setCompressionQuality(1.0f);
		} else if (size <= 250000) {
			param.setCompressionQuality(0.75f);
		} else {
			param.setCompressionQuality(0.5f);
		}

		writer.write(null, new IIOImage(image, null, null), param);

		outStream.close();
		imageOutStream.close();
		writer.dispose();
	}

	private static void copy(final File in, File out) throws IOException {
		if (in.isDirectory()) {
			for (final String name : in.list()) {
				copy(new File(in, name), new File(out, name));
			}
		} else if (in.isFile()) {
			copyFile(in, out);
		} else {
			throw new IllegalStateException(in.getAbsolutePath());
		}
	}

	private static void copyFile(final File in, final File out) throws IOException {
		final BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(in));
		final BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(out));

		final byte[] buffer =new byte[4096];
		int len;
		while ((len = inStream.read(buffer, 0, buffer.length)) != -1) {
			outStream.write(buffer, 0, len);
		}
		outStream.flush();
	}

}
