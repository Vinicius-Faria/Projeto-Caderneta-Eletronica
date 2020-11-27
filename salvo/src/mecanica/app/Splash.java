package mecanica.app;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.geom.Rectangle2D;

import com.sun.prism.paint.Color;

public class Splash {

    private static SplashScreen mySplash;
    private static Graphics2D splashGraphics;
    private static Rectangle2D.Double splashProgressArea;

    public static void splashInit() {

        mySplash = SplashScreen.getSplashScreen();

        if (mySplash != null) {
            //pega as dimensoes da imagem que será usada no splashscreen
            // para que a barra fique proporcional
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            //desenha a área da barra de progresso, você pode alterar as dimensoes pra testar a que mais gostar
            //  os parametros representam posição horizontal  e vertical (em relação a imagem), altura e largura, respectivamente
            splashProgressArea = new Rectangle2D.Double(1.0, height * 0.87, width, height * 0.08);
            //exibe a imagem do splash centralizada na tela
            splashGraphics = mySplash.createGraphics();
            //inicia a barra de progresso(pode ser removido)
            splashProgress(0);
        }
    }

    public static void splashProgress(int pct) {
        if (mySplash != null && mySplash.isVisible()) {
            
            //preenche a area da barra de progresso com a cor informada
           // splashGraphics.setPaint(Color.BLACK);
            splashGraphics.fill(splashProgressArea);
            
            //colore bordas na barra de progresso(opcional)
           // splashGraphics.setPaint(Color.BLUE);
            splashGraphics.draw(splashProgressArea);
            
            //pega o menor valor das coordenadas(horizontal  X e vertical Y) da barra 
            //será usado para o carregamento(não alterar daqui em diante)
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();
            
            //valor usado para o carregamento da barra
            int doneWidth = Math.round(pct * wid / 100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid - 1));
            
            //aqui  é que vai preenchendo o carregamento da barra de acordo com o valor
            //passado em pct    
           //
           // splashGraphics.setPaint(Color.GREEN);
            splashGraphics.fillRect(x, y + 1, doneWidth, hgt - 1);
            mySplash.update();
        }
    }
}