import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Player extends CharacterTmp {
    public ArrayList<Skill> skillList = new ArrayList<Skill>();   // スキルリスト

    class Skill {
        String name;    // 名称
        float power;   // 威力
        float speed; // 速さ
        
        Skill(String name, float power, float speed) {
            this.name = name;
            this.power = power;
            this.speed = speed;
        }
    }

    // コンストラクタ
    Player() {
        name = "勇者";
        hp = 20;
        attack = 3;
        speed = 3;
        isLive = true;
        SkillSet();
    }

    Player(String name, float hp, float attack, float speed) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
        isLive = true;
        SkillSet();
    }

    // スキルをセット
    public void SkillSet() {
        // スキルを設定
        Skill skiil1 = new Skill("こうげき", 0, 0);
        Skill skiil2 = new Skill("かえん切り", 8, 5);
        Skill skiil3 = new Skill("ヒャド", 6, 2);
        
        // リストに追加
        skillList.add(skiil1);
        skillList.add(skiil2);
        skillList.add(skiil3);
    }

    // 攻撃時速度変化
    public void ChangeSpeed() {
        for (Skill var : skillList) {
            System.out.printf("%d %s%n", skillList.indexOf(var) + 1, var.name);
        }
        Random random = new Random();
        chSpeed = speed + (random.nextInt(5) - 2);
    }

    // 攻撃コマンド
    public void AttackCommand(CharacterTmp opponent) {
        System.out.printf("%sのこうげき！%n", name);
        opponent.ReceiveDamage(attack);
    }

    // ダメージ処理
    public void ReceiveDamage(float damage) {
        hp -= damage;
        System.out.printf("%sは%1.0fのダメージを受けた！%n%n", name, damage);
        if (hp <= 0) {
            isLive = false;
            System.out.printf("%sは死んでしまった！%n%n", name);
        }
    }
}