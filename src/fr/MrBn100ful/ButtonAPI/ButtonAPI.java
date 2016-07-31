
package fr.MrBn100ful.ButtonAPI;
/**
 *  
 * @author MrBn100ful
 * 
 */
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.WritableRaster;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class ButtonAPI
{

    public static final String VERSION = "1.0.0-BETA";


    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);

    public static final int LITTLE_TRANSPARENT = 50;

    public static final Color LITTLE_TRANSPARENT_WHITE = getTransparentWhite(LITTLE_TRANSPARENT);

    public static final Color HOVER_COLOR = LITTLE_TRANSPARENT_WHITE;

    public static final Color DISABLED_COLOR = getTransparentInstance(Color.GRAY, LITTLE_TRANSPARENT);

    private static String resourcePath;

    public static void setSystemLookNFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("[Swinger] WARNING: Can't set the system look n feel : " + e);
        }
        catch (InstantiationException e)
        {
            System.out.println("[Swinger] WARNING: Can't set the system look n feel : " + e);
        }
        catch (IllegalAccessException e)
        {
            System.out.println("[Swinger] WARNING: Can't set the system look n feel : " + e);
        }
        catch (UnsupportedLookAndFeelException e)
        {
            System.out.println("[Swinger] WARNING: Can't set the system look n feel : " + e);
        }
    }

    public static Color getTransparentWhite(int transparency)
    {
        return getTransparentInstance(Color.WHITE, transparency);
    }

    public static Color getTransparentInstance(Color color, int transparency)
    {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), transparency);
    }

    public static BufferedImage copyImage(BufferedImage image)
    {
        ColorModel cm = image.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = image.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }


    public static Image fillImage(Image image, Color color, ImageObserver imageObserver)
    {
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, image.getWidth(imageObserver), image.getHeight(imageObserver));

        return image;
    }


    public static String getResourcePath()
    {
        return resourcePath;
    }


    public static void setResourcePath(String resourcePath)
    {
        ButtonAPI.resourcePath = resourcePath.endsWith("/") ? resourcePath.substring(0, resourcePath.length() - 1) : resourcePath;
    }

    public static BufferedImage getResource(String resource)
    {
        try
        {
            return ImageIO.read(ButtonAPI.class.getResourceAsStream(getResourcePath() + "/" + resource));
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("Can't load the given resource (" + getResourcePath() + "/" + resource + ") : " + e);
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Can't load the given resource (" + getResourcePath() + "/" + resource + ") : " + e);
        }
    }


    public static BufferedImage getResourceIgnorePath(String resource)
    {
        try
        {
            return ImageIO.read(ButtonAPI.class.getResourceAsStream(resource));
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("Can't load the given resource (" + resource + ") : " + e);
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Can't load the given resource (" + resource + ") : " + e);
        }
    }

    public static int percentage(int value, int maximum)
    {
        return crossMult(value, maximum, 100);
    }

    public static int crossMult(int value, int maximum, int coefficient)
    {
        return (int) ((double) value / (double) maximum * (double) coefficient);
    }


    public static Point getRecCenterPos(Rectangle parent, Rectangle rectangle)
    {
        double x = parent.getWidth() / 2 - rectangle.getWidth() / 2;
        double y = parent.getHeight() / 2 + rectangle.getHeight() / 2;

        return new Point((int) x, (int) y);
    }

    public static Point getStringCenterPos(Rectangle parent, String str, FontMetrics fontMetrics, Graphics g)
    {

        Rectangle2D stringBounds = fontMetrics.getStringBounds(str, g);


        double x = ((parent.getWidth() - stringBounds.getWidth()) / 2);
        double y = ((parent.getHeight() - stringBounds.getHeight()) / 2 + fontMetrics.getAscent());
        return new Point((int) x, (int) y);
    }


    public static void drawCenteredString(Graphics g, String str, Rectangle parent)
    {

        FontMetrics fm = g.getFontMetrics();

        Point centerPos = getStringCenterPos(parent, str, fm, g);

        g.drawString(str, (int) centerPos.getX(), (int) centerPos.getY());
    }

    public static void activateAntialias(Graphics g)
    {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    public static BufferedImage colorImage(BufferedImage image, int red, int green, int blue)
    {

        BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TRANSLUCENT);
        Graphics2D graphics = img.createGraphics();

        Color newColor = new Color(red, green, blue, 0);

 
        graphics.setXORMode(newColor);
        graphics.drawImage(image, null, 0, 0);
        graphics.dispose();


        return img;
    }

    public static void drawFullsizedImage(Graphics g, JComponent component, Image image)
    {
        g.drawImage(image, 0, 0, component.getWidth(), component.getHeight(), component);
    }


    public static void fillFullsizedRect(Graphics g, JComponent component)
    {
        g.fillRect(0, 0, component.getWidth(), component.getHeight());
    }


    public static void fillFullsizedRect(Graphics g, JComponent component, Color color)
    {
        g.setColor(color);
        g.fillRect(0, 0, component.getWidth(), component.getHeight());
    }
}
