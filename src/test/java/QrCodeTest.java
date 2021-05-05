import org.junit.Test;
import utils.qrcode.QRCodeUtil;

/**
 * @description:
 * @author: suyue
 * @time: 2021/5/5 18:55
 */
public class QrCodeTest {

    @Test
    public void qrCodeTest() throws Exception {
        // 存放在二维码中的内容
        String text = "http://124.196.2.2:10028/down?name=f879cb8bd25488d6967bb73ca9081343&token=95257f58a82c4471743c5cacc68a00cd&password=$2y$10$.tD9BKC6HPnmjnX1a8q0UuwqwPBOVNDIXONwt3nP8DO8g0KuEv.H.";
        // 嵌入二维码的图片路径
//        String imgPath = "G:/qrCode/dog.jpg";
        String imgPath = null;
        // 生成的二维码的路径及名称
        String destPath = "src/main/resources/image/qrcode.jpg";
        //生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
//        String str = QRCodeUtil.decode(destPath);
        String str = QRCodeUtil.decodeNew(destPath);
        // 打印出解析出的内容
        System.out.println(str);
    }
}
