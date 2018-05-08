package inter;

import java.util.Scanner;

public class Tv implements RemoteCon {

	boolean bOnOff; // ����/��������
	int volume; // ��������
	int channel; // ä�λ���
	Scanner s = new Scanner(System.in);

	public Tv() {
		volume = 10;
		channel = 9;
	}

	@Override
	public void volumeUp() {
		volume++;
		if (volume > Volume.MAX_VOLUME)
			volume = Volume.MAX_VOLUME;

		showTv();
	}

	@Override
	public void volumDown() {

		volume--;
		if (volume < Volume.MIN_VOLUME)
			volume = Volume.MIN_VOLUME;

		showTv();

	}

	@Override
	public void volumeZero() {

		volume = Volume.MIN_VOLUME;

		showTv();

	}

	@Override
	public void channelUp() {
		channel++;

		if (channel > Channel.MAX_CHANNEL)
			channel = Channel.MIN_CHANNEL;

		showTv();

	}

	@Override
	public void channelDown() {
		channel--;

		if (channel < Channel.MIN_CHANNEL)
			channel = Channel.MAX_CHANNEL;

		showTv();

	}

	@Override
	public void setChannel(int channel) {
		if (channel >= MIN_CHANNEL && channel <= MAX_CHANNEL)
			this.channel = channel;
		else
			System.out.println("ä�� �Է� ����");

		showTv();

	}

	public void setChannel() {
		int c = s.nextInt();
		if (c >= MIN_CHANNEL && c <= MAX_CHANNEL)
			this.channel = c;
		else
			System.out.println("ä�� �Է� ����");

		showTv();
	}

	@Override
	public void onOff() {

		bOnOff = !bOnOff;
		// �̰Թٷ� ��۹��

		showTv();

	}

	@Override
	public void showTv() {

		if (bOnOff == false) {
			System.out.println("---���� TV ����---");
			return;
		}

		System.out.println("------[ TV ���� ]--------");
		System.out.printf("-- ä�� : %d\n", channel);
		System.out.printf("-- ���� : %d\n", volume);
		System.out.println("-------------------------");

	}

}
