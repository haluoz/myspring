package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2023/1/9
 */
public class CountingWordsWithAGivenPrefix2185 {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        int n = pref.length();
        int count = 0;
        for (String word : words) {
            for (int i = 0; i < n && n <= word.length(); i++) {
                char wordChar = word.charAt(i);
                char prefChar = pref.charAt(i);
                if (wordChar == prefChar){
                    count++;
                }
                if (count == n){
                    count = 0;
                    ans++;
                    break;
                }
            }
            count = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingWordsWithAGivenPrefix2185 solution = new CountingWordsWithAGivenPrefix2185();
//        String[] strings = {"ggyjnmgfgymvwbwiwredqaljraxnbprhgtbobdsiihonllxclwdxelcwzvmdltdcnqkwjwnjbwesgtnewpuhfvkobyydccpsns", "vcbvyvsghjvefpivratytcyshtznwhhltzatbjzqpbmcehfnkkiuolwcxaaapnaaosebprqnqyzcppsgslzalckyni", "wsiannwwwenltjockpmlixvefzxvrgwfnhasccwsyovedqjbxljz", "tzikyrjjbualsgokxjbaphsktqdxsozfemyldmnyddrqschpxdlbtdcesnntwcpvimojlbtrplvxrscuzzxbol", "nwjypnjshucgvfqdoturrlzkikwpw", "gukgpicu", "pwkodomkgjimgksrspospuodebhdahi", "gancselcybxqxgjfulbrmxjxbhrvpcphzwqufotlxelezgqwsxkoppbagkbefwaaloumtdnrk", "erwberftypvefvfjnw", "oeudwulwllmqtrgibfsdjkecdtybi", "gtnvlmbgkvhjpgcfaccmtwlysdut", "mavljzrjedmzeoxhjucikuitaqjrtfohmdzohxjglyyhocgknrtdnitphcjgpcxjkuo", "flqbjtdegwavryy", "ffejgwmjstbwamcbluqrdslsnpzuejvtnnaygpyl", "xwnyayyqadgrzivlbenzcrbiddhgarjhvlwicmmj", "kvruxbabmxddfsoxixtduduchptxybzqjmoyuppqbjpkljcykicmbydsafysukqxndithbsoxfgkjbjtqhmswxiyjhc", "gwkebipsfqyrgt", "yk", "rbufawosreilufkwhgdzdsexlacvvihqemncensnxwzkjgeh", "srzpwzbxkmzjaipjonysriwhcdrcduvgjgqgaskywqlyhlardpbkdgxfgtqmglmeqdyclzirhwkjbidgcyown", "ordwukwmowmlndzpoxqsvpqaiqnmhmlxhfpmbxulnsvcjsvmlpzdccurlygnw", "wrwmsebozobgxbacueodzylzcqjybmuurfyjroqeqwlhgxizxswh", "uleikehhnjvntfqguisjmkelairmtcvpoabacdmlvnvdcextbnurflzxxuco", "epigbitfmgjzyshxpnykuaeqdmumzizhqdizczwj", "swesiodbtslozadpuqanynjzxzrhhcznpdeqktnhuhyypzibaqtxxvpbigsabqrqkgstytzwwwqv", "earqjforxdlgtukpsgetzgzmcyfxkysvwjpybphomtoquilburlnmhuwukwulegcsixzjzadlu", "tkohetvaxmcxecqmdlvfuocosywrvjnugqwjuachaosdkwdofcbcbknkubrvkygdpnktxqywptslgldwnnrapaqktxpvltc", "kpyzh", "bkqveaciwjjwztwzqtvvqqbhywsiubsgxpzhsoy", "fdosywemucqkhnealmflaozkoambptbvqnicuy", "cmci", "kqgiltewwvw", "zhfynbrfrpjznbgqwlhexh", "puustxetqalorsayxjdzxuakt", "qrpgykpexorsabmxjjzkpsjdrce", "pljvyfbghtauvdpgjecbupzegnrnyhxvvyozrmoyzcrcjhppqwgcsnndwszpcfnokxqgfgnhudeykvywaasgsynvpayz", "glveotcgpldrgudegivbarqkvzixjlenqbdlpufiavimkmdrbgmnqksqjqrbalwdrosttnoxwrdqdkjfpwqfa", "pohvrrgkodgbvqkejhotuztajxqsakbeaatbrdnhplzybvnkijnnrdqukabrklxjcnminzyejymvmyx", "zgkwfwyyenhcnqfpwgeoopaojiaakkzluwkdtrfhpicxzumjirjezaevlslsxzerooynawfulecarkmydvjztjmvszzujqlqsz", "qspoaclvarmlvxursgxetmzvkmuatlbcrirgzxhqigyswzdbcnkhofpdjeoziyywbgrhndcpxtnpaxem", "lssnivjlgchaldwhbpucntfpswaeeatjxzxgm", "twnwzot", "izoiafwibhlpkilouuzaqwbxjndwjxuwxurygrlkmwkexesl", "fizcljmqykidkrsocram", "lbqmvnjcwfpoahxuomdrfqrzhzvbwyiyolauaevubkpxykycgifjaazynbicvqtzbwitmlsnfqszwi", "oaxdwbygtqgcvjsglxuvjvmfhifaxxa", "inpcbocaovurxqknuuthyiduezgzmdbuxrlwdgysfwmmkhdgmetdnomguxwnmxfhiazrvejgswqqhaqgrmhigizjqtemyz", "kflfolxhgiuyfqjjcruhdesuscoslgjtolyleojysoxobvpyfwtmyfxctbasmynarbsshgvqiffci", "egqoshwtaboojlpplrzuodbxhgcuazylpcwmkctxvuxaalxuvmkwiwdxtxpzudizinq", "xvxfogxsrhugoufcmrbpbizjjifdqmtthovpczlxaxfogeamwblspehnksivseusrvrlw", "dbntqfmj", "sgbpnbimcupgwroursekqbpyyqsemi", "jzuimoptye", "pycxtdziorehxlqdjvnfnhexldfjfqcmeoklnayvlojudmucyyoqlbnvrvz", "kdci", "wrpeqkfznrubtxbsplyhijzfgblvkjyzasieijuirbqjgykeqmlssbxjx", "amimolayqqmpfupretmsjwvywzvtllbraaagmnroiqfzwuetplkijonkzwktfrtqayoqupvlfznrbyxvwm", "ikcip", "oitufiiafouduwzdrdciwhsqhtscikhrdugretrzxrtaedgicyxqnpznfmgolcwkugritcpzfpgkqqpyksz", "mqelmmkptawcbzhiojccdvrnscpkxdrxwpvxvpjqjybuokjbvgv", "xbiupbctskmopexnqwrjmgeghzujpmkdzevofiaxdigvmwnupnpksjwix", "pzsnnybzpdcmejgqwuzudydkzecfrojhhngjsrhxbtfp", "wudcvdlqgwxjuawaltgvvnbdqtdmzotnrovauacvjflnouvcjgogrzlrjwxcybftydizn", "zocrdllrcdxvkdzvcyuspkxfbsu", "bhjsdkarnmciiuqlbussygeryeqeqeffevtrxwezvctnuqbqqkgeeuiyyjperjvegrczx", "ywmhtdetmrgluhdqszqjcsauwtlbelhvzfecdarmdfnzgaeagbjbnojujjlmxzivwgqsmce", "xrjxcoyulhzbmehfxsgqecwciyrfdhpekbkewolqgarcwgqtowmntdtzwtzzyjymhdsanbnlmwyctzr", "wb"};
        String[] strings = {"sxyjellhlh","sxyjellhlh","sxyjellhlh"};
        System.out.println(solution.prefixCount(strings, "sxyjellhlh"));
    }
}
