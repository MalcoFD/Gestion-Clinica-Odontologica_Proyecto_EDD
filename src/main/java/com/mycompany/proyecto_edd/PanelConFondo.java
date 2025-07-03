
package com.mycompany.proyecto_edd;

import javax.swing.*;
import java.awt.*;

public class PanelConFondo extends JPanel {
    private Image fondo;
    private int imagenAncho;
    private int imagenAlto;

    public PanelConFondo(String rutaImagen) {
        fondo = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
        imagenAncho = fondo.getWidth(null);
        imagenAlto = fondo.getHeight(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelAncho = getWidth();
        int panelAlto = getHeight();

        // Enfocar la parte central derecha (ajusta según necesidad)
        int xInicio = Math.max(0, imagenAncho / 2 - panelAncho / 2 + 200); // 200 px desplazamiento a la derecha
        int yInicio = Math.max(0, imagenAlto / 2 - panelAlto / 2);         // centra verticalmente

        // Asegura no pasarse del borde de la imagen
        if (xInicio + panelAncho > imagenAncho) xInicio = imagenAncho - panelAncho;
        if (yInicio + panelAlto > imagenAlto) yInicio = imagenAlto - panelAlto;
        if (xInicio < 0) xInicio = 0;
        if (yInicio < 0) yInicio = 0;

        g.drawImage(fondo,
            0, 0, panelAncho, panelAlto,               // Dónde se dibuja (en el panel)
            xInicio, yInicio, xInicio + panelAncho, yInicio + panelAlto,  // Parte de la imagen
            this
        );
    }
}