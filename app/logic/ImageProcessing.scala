package rakuitembg.logic

import java.awt.image.BufferedImage

object ImageProcessing {

  def load(urlStr: String) = {
    import java.net.URL
    import javax.imageio.ImageIO

    val url = new URL(urlStr)
    ImageIO.read(url)
  }

  def brighten(img: BufferedImage) = {
    for {
      x <- img.getMinX until (img.getMinX + img.getWidth)
      y <- img.getMinY until (img.getMinY + img.getHeight)
    } {
      val c = img.getRGB(x, y)
      img.setRGB(x, y, brightenPixel(c))
    }
    img
  }

  def brightenPixel(c: Int) = {
    import java.awt.Color
    def cap: Int => Int = {
      case i if i > 255 => 255
      case i if i < 0 => 0
      case i => i
    }
    val color = new Color(c)
    new Color(
       cap(color.getRed + 120)
      ,cap(color.getGreen + 120)
      ,cap(color.getBlue + 120)
      ,color.getAlpha
    ) getRGB
  }

  def byteArray(img: BufferedImage) = {
    import javax.imageio.ImageIO
    import java.io.ByteArrayOutputStream
    val out = new ByteArrayOutputStream
    ImageIO.write(img, "png", out)
    out.toByteArray
  }

  def tileImage(imgs: Seq[BufferedImage]) = {
    val making = new BufferedImage(128 * 4, 128 * 4, BufferedImage.TYPE_INT_ARGB)
    val g = making.createGraphics
    for {
      x <- 0 to 3
      y <- 0 to 3
    } {
      val xp = x * 128
      val yp = y * 128
      imgs.lift(y * 4 + x) foreach { g.drawImage(_, null, xp, yp) }
    }
    making
  }
}
