import java.util.*;

class RankingTotalScore implements Comparator<grade>
{
    public int compare(grade g1, grade g2){
        int TsResult = (int)g2.getTotalGrade() - (int)g1.getTotalGrade();
        if(TsResult != 0)
        {
            return TsResult;
        }
        else
        {
            int SiteResult =  g1.getSite() - g2.getSite();
            if(SiteResult != 0)
            {
                return SiteResult;
            }
            else
            {
                return (int) (g1.getlastN().compareTo(g2.getlastN()));
            } 

        }

    }
}