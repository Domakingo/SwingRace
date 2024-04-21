import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControllerP1 implements KeyListener {

    private Player player;
    private Model model;
    private Game game;
    private boolean started = false;

    public ControllerP1(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (!started && (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A ||
                keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D)) {
            started = true;
            game.removeSalvagente(1);
            game.repaint();
        }

        if (started) {
            switch (keyCode) {
                case KeyEvent.VK_W:
                    player.setPos(0);
                    break;
                case KeyEvent.VK_A:
                    player.setPos(1);
                    break;
                case KeyEvent.VK_S:
                    player.setPos(2);
                    break;
                case KeyEvent.VK_D:
                    player.setPos(3);
                    break;
                default:
                    break;
            }

            model.addRiga(player);
            model.checkDanno(player);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
