package zn.leave.infrastructure.redis.lua;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/04/21
 */
public class HashSetLua {



    private String lua =

            " redis.call('hset', KEYS[1],KEYS[2],KEYS[3]) \n" +
                    "            redis.call(‘expire’,KEYS[1],ARGV[1])\n" +
                    "                   end\""

            ;

}
