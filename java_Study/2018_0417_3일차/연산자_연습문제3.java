import java.util.Scanner;
class ������_��������3
{
   public static void main(String[] args) 
   {
      Scanner scan = new Scanner(System.in);
      double ki = 162.54;
      double ki1 = ki;

   double count_12;
   double count_254;

   count_254 = ki/2.54;
   //ki = ki % 2.54;
//��? �̷��� ���ص� ���ݾƿ� ����
   count_12 = (ki/2.54)/12.0; //12�� ���ϴ°� �ƴ϶� /12�� ��������!
//2.54�� �ٲ�� �ǰ�
   System.out.printf("%.2f(cm)�� ���� ������ ����\n",ki1);
   System.out.printf("%f��Ʈ\n",count_12);//�� �κ��� Ʋ�Ⱦ��. %d�� ������ �ȳ�����.
   System.out.printf("%.5f��ġ�̴�\n",count_254);
   }
}