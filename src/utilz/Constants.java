package utilz;
public class Constants
 { 
    
    public static class EnemyConstants {
    public static final int CRABBY = 0;

    public static final int IDLE = 0;
    public static final int RUNNING = 1;
    public static final int ATTACK = 2;
    public static final int HIT = 3;
    public static final int DEAD = 4;

    public static final int CRABBY_WIDTH_DEFAULT = 72;
    public static final int CRABBY_HEIGHT_DEFAULT = 32;



    public static int GetSpriteAmount(int enemy_type, int enemy_state) {

        switch (enemy_type) {
        case CRABBY:
            switch (enemy_state) {
            case IDLE:
                return 9;
            case RUNNING:
                return 6;
            case ATTACK:
                return 7;
            case HIT:
                return 4;
            case DEAD:
                return 5;
            }
        }

        return 0;

    }

}

    
    public static class Directions{
        public static int left=0;
        public static int top=1;
        public static int right=2;
        public static int down=3;

        

   }

   public static int getMaxHealth(int enemy_type)
   {
      switch(enemy_type)
       {
        case 0:
        return 10;
        default:
        return-1;
       }
   }
   public static int getEnemyDmg(int enemy_type)
   {
    switch(enemy_type)
    {
        case 0:
        return 15;
        default :
        return 0;



    }
   }
    public static class PlayerAction{
        public static final int idle =0;
        public static final int running =1;
        public static final int jump=2;
        public static final int falling =3;
        public static final int hit=5;
        public static final int attack =4;
        public static final int dead=6;

        public static int playerSprites(int player_Action)
        {
            switch(player_Action)
            {
                case idle:
                return 5;
                case running:
                return 6;
                case jump: case attack:
                return 3;
                case hit:
                return 4;
                case falling:
                return 1;
               case dead:
               return 8;
                default: 
                return -1;
            }
        }


    }


}
