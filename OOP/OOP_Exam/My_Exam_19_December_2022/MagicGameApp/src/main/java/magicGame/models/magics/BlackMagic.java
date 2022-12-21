package magicGame.models.magics;

public class BlackMagic extends MagicImpl{

    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);

    }

    @Override
    public int fire() {
        int thisCount = getBulletsCount();
        if(thisCount < 10){
            return 0;
        }

        setBulletsCount(thisCount - 10);
        return 10;
    }
}
