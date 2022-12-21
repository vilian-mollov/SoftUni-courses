package magicGame.models.magics;

public class RedMagic extends MagicImpl{

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int thisCount = getBulletsCount();
        if(thisCount < 1){
            return 0;
        }

        setBulletsCount(thisCount - 1);
        return 1;
    }
}
