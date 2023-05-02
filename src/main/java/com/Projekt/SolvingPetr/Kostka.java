package com.Projekt.SolvingPetr;

public class Kostka {
    private final Kosticka[][][] kostka = new Kosticka[3][3][3];

    public Kostka() {
//F
        kostka[0][0][0] = new Kosticka(0, 0, 0, true, false,
                new KostickaBarva[]{new KostickaBarva('Y', 'U'), new KostickaBarva('R', 'L'), new KostickaBarva('G', 'F')});
        kostka[1][0][0] = new Kosticka(1, 0, 0, false, true,
                new KostickaBarva[]{new KostickaBarva('Y', 'U'), new KostickaBarva('G', 'F')});
        kostka[2][0][0] = new Kosticka(2, 0, 0, true, false,
                new KostickaBarva[]{new KostickaBarva('Y', 'U'), new KostickaBarva('G', 'F'), new KostickaBarva('O', 'R')});

        kostka[0][0][1] = new Kosticka(0, 0, 1, false, true,
                new KostickaBarva[]{new KostickaBarva('R', 'L'), new KostickaBarva('G', 'F')});
        kostka[1][0][1] = new Kosticka(1, 0, 1, false, false,
                new KostickaBarva[]{new KostickaBarva('G', 'F')});
        kostka[2][0][1] = new Kosticka(2, 0, 1, false, true,
                new KostickaBarva[]{new KostickaBarva('G', 'F'), new KostickaBarva('O', 'R')});

        kostka[0][0][2] = new Kosticka(0, 0, 2, true, false,
                new KostickaBarva[]{new KostickaBarva('W', 'D'), new KostickaBarva('R', 'L'), new KostickaBarva('G', 'F')});
        kostka[1][0][2] = new Kosticka(1, 0, 2, false, true,
                new KostickaBarva[]{new KostickaBarva('W', 'D'), new KostickaBarva('G', 'F')});
        kostka[2][0][2] = new Kosticka(2, 0, 2, true, false,
                new KostickaBarva[]{new KostickaBarva('W', 'D'), new KostickaBarva('G', 'F'), new KostickaBarva('O', 'R')});

//B
        kostka[0][2][0] = new Kosticka(0, 2, 0, true, false,
                new KostickaBarva[]{new KostickaBarva('Y', 'U'), new KostickaBarva('R', 'L'), new KostickaBarva('B', 'B')});
        kostka[1][2][0] = new Kosticka(1, 2, 0, false, true,
                new KostickaBarva[]{new KostickaBarva('Y', 'U'), new KostickaBarva('B', 'B')});
        kostka[2][2][0] = new Kosticka(2, 2, 0, true, false,
                new KostickaBarva[]{new KostickaBarva('Y', 'U'), new KostickaBarva('B', 'B'), new KostickaBarva('O', 'R')});

        kostka[0][2][1] = new Kosticka(0, 2, 1, false, true,
                new KostickaBarva[]{new KostickaBarva('R', 'L'), new KostickaBarva('B', 'B')});
        kostka[1][2][1] = new Kosticka(1, 2, 1, false, false,
                new KostickaBarva[]{new KostickaBarva('B', 'B')});
        kostka[2][2][1] = new Kosticka(2, 2, 1, false, true,
                new KostickaBarva[]{new KostickaBarva('B', 'B'), new KostickaBarva('O', 'R')});

        kostka[0][2][2] = new Kosticka(0, 2, 2, true, false,
                new KostickaBarva[]{new KostickaBarva('W', 'D'), new KostickaBarva('R', 'L'), new KostickaBarva('B', 'B')});
        kostka[1][2][2] = new Kosticka(1, 2, 2, false, true,
                new KostickaBarva[]{new KostickaBarva('W', 'D'), new KostickaBarva('B', 'B')});
        kostka[2][2][2] = new Kosticka(2, 2, 2, true, false,
                new KostickaBarva[]{new KostickaBarva('W', 'D'), new KostickaBarva('B', 'B'), new KostickaBarva('O', 'R')});

//S
        kostka[0][1][0] = new Kosticka(0, 1, 0, false, true,
                new KostickaBarva[]{new KostickaBarva('R', 'L'), new KostickaBarva('Y', 'U')});
        kostka[1][1][0] = new Kosticka(1, 1, 0, false, false,
                new KostickaBarva[]{new KostickaBarva('Y', 'U')});
        kostka[2][1][0] = new Kosticka(2, 1, 0, false, true,
                new KostickaBarva[]{new KostickaBarva('Y', 'U'), new KostickaBarva('O', 'R')});

        kostka[0][1][1] = new Kosticka(0, 1, 1, false, false,
                new KostickaBarva[]{new KostickaBarva('R', 'L')});
        kostka[1][1][1] = new Kosticka(1, 1, 1, false, false,
                new KostickaBarva[]{new KostickaBarva('A', 'A')});
        kostka[2][1][1] = new Kosticka(2, 1, 1, false, false,
                new KostickaBarva[]{new KostickaBarva('O', 'R')});

        kostka[0][1][2] = new Kosticka(0, 1, 2, false, true,
                new KostickaBarva[]{new KostickaBarva('R', 'L'), new KostickaBarva('W', 'D')});
        kostka[1][1][2] = new Kosticka(1, 1, 2, false, false,
                new KostickaBarva[]{new KostickaBarva('W', 'D')});
        kostka[2][1][2] = new Kosticka(2, 1, 2, false, true,
                new KostickaBarva[]{new KostickaBarva('W', 'D'), new KostickaBarva('O', 'R')});
    }

    public int pocetBilychHran() {
        int x = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (kostka[i][j][0].isHrana()) {
                    if (kostka[i][j][0].getSmerBarvy('W') == 'U') {
                        x++;
                    }
                }
            }
        }
        return x;
    }

    public boolean bilyRohU() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (kostka[i][j][0].isRoh()) {
                    if (kostka[i][j][0].getSmerBarvy('W') != 'A')
                        return true;
                }
            }
        }
        return false;
    }

    public boolean nezluteHranyU() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (kostka[i][j][0].isHrana()) {
                    if (kostka[i][j][0].getSmerBarvy('Y') == 'A')
                        return true;
                }
            }
        }
        return false;
    }

    public boolean bilyRohSpravne() {
        boolean bila = false;

        if (kostka[2][0][0].isRoh() && kostka[2][0][0].getSmerBarvy('W') == 'A') {
            return false;
        }

        if (kostka[2][0][0].getSmerBarvy('W') == 'U') {
            bila = true;
        }

        if (bila) {
            return (kostka[2][0][0].getBarvaSmeru('R') == kostka[1][0][1].getBarvy()[0].getBarva() &&
                    kostka[2][0][0].getBarvaSmeru('F') == kostka[2][1][1].getBarvy()[0].getBarva());
        } else {
            return (kostka[2][0][0].getBarvaSmeru('R') == kostka[2][1][1].getBarvy()[0].getBarva() ||
                    kostka[2][0][0].getBarvaSmeru('F') == kostka[1][0][1].getBarvy()[0].getBarva());
        }
    }

    public boolean rohSpravne(int x, int y, int z) {
        if (kostka[x][y][z].isRoh()) {
            return (kostka[x][y][z].getBarvaSmeru('D') == kostka[1][1][2].getBarvy()[0].getBarva() &&
                    kostka[x][y][z].getBarvaSmeru('F') == kostka[1][0][1].getBarvy()[0].getBarva() &&
                    kostka[x][y][z].getBarvaSmeru('R') == kostka[2][1][1].getBarvy()[0].getBarva());
        }
        return false;
    }

    public int zluteRohy() {
        int a = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (kostka[i][j][0].isRoh() && kostka[i][j][0].getSmerBarvy('Y') == 'U')
                    a++;
            }
        }
        return a;
    }

    private Kosticka[][] otoceniPole(char[] pre, char[] post, int stupne, Kosticka[][] puvodni) {
        Kosticka[][] otoceno = new Kosticka[3][3];

        if (stupne == 90) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    otoceno[i][j] = puvodni[j][i];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < otoceno[0].length / 2; j++) {
                    Kosticka a = otoceno[i][3 - j - 1];
                    otoceno[i][3 - j - 1] = otoceno[i][j];
                    otoceno[i][j] = a;
                }
            }
        } else if (stupne == -90) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    otoceno[i][j] = puvodni[j][i];
                }
            }
            for (int i = 0; i < otoceno[0].length / 2; i++) {
                for (int j = 0; j < 3; j++) {
                    Kosticka a = otoceno[3 - i - 1][j];
                    otoceno[3 - i - 1][j] = otoceno[i][j];
                    otoceno[i][j] = a;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                KostickaBarva[] a = otoceno[i][j].getBarvy();
                for (int k = 0; k < a.length; k++) {
                    int b = 6;
                    for (int x = 0; x < pre.length; x++) {
                        if (a[k].getSmer() == pre[x]) {
                            b = x;
                        }
                    }
                    if (b < post.length)
                        a[k].setSmer(post[b]);
                }
                otoceno[i][j].setBarvy(a);
            }
        }
        return otoceno;
    }

    public void otoceni(String otoceni) {
        char[] pre;
        char[] post;
        Kosticka[][] pole = new Kosticka[3][3];

        if (otoceni.equals("U")) {
            pre = new char[]{'U', 'F', 'L', 'B', 'R'};
            post = new char[]{'U', 'L', 'B', 'R', 'F'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][Math.abs(i - 2)][0];
                }
            }
            pole = otoceniPole(pre, post, 90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][Math.abs(i - 2)][0] = pole[i][j];
                }
            }

        } else if (otoceni.equals("U'")) {
            pre = new char[]{'U', 'L', 'B', 'R', 'F'};
            post = new char[]{'U', 'F', 'L', 'B', 'R'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][Math.abs(i - 2)][0];
                }
            }
            pole = otoceniPole(pre, post, -90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][Math.abs(i - 2)][0] = pole[i][j];
                }
            }
        } else if (otoceni.equals("D")) {
            pre = new char[]{'D', 'L', 'B', 'R', 'F'};
            post = new char[]{'D', 'F', 'L', 'B', 'R'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][i][2];
                }
            }
            pole = otoceniPole(pre, post, 90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][i][2] = pole[i][j];
                }
            }
        } else if (otoceni.equals("D'")) {
            pre = new char[]{'D', 'F', 'L', 'B', 'R'};
            post = new char[]{'D', 'L', 'B', 'R', 'F'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][i][2];
                }
            }
            pole = otoceniPole(pre, post, -90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][i][2] = pole[i][j];
                }
            }
        } else if (otoceni.equals("F")) {
            pre = new char[]{'F', 'U', 'R', 'D', 'L'};
            post = new char[]{'F', 'R', 'D', 'L', 'U'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][0][i];
                }
            }
            pole = otoceniPole(pre, post, 90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][0][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("F'")) {
            pre = new char[]{'F', 'U', 'R', 'D', 'L'};
            post = new char[]{'F', 'L', 'U', 'R', 'D'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][0][i];
                }
            }
            pole = otoceniPole(pre, post, -90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][0][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("B")) {
            pre = new char[]{'B', 'U', 'R', 'D', 'L'};
            post = new char[]{'B', 'L', 'U', 'R', 'D'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[Math.abs(j - 2)][2][i];
                }
            }
            pole = otoceniPole(pre, post, 90, pole);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[Math.abs(j - 2)][2][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("B'")) {
            pre = new char[]{'B', 'U', 'R', 'D', 'L'};
            post = new char[]{'B', 'R', 'D', 'L', 'U'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[Math.abs(j - 2)][2][i];
                }
            }
            pole = otoceniPole(pre, post, -90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[Math.abs(j - 2)][2][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("L")) {
            pre = new char[]{'L', 'B', 'D', 'F', 'U'};
            post = new char[]{'L', 'U', 'B', 'D', 'F'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[0][Math.abs(j - 2)][i];
                }
            }
            pole = otoceniPole(pre, post, 90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[0][Math.abs(j - 2)][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("L'")) {
            pre = new char[]{'L', 'U', 'B', 'D', 'F'};
            post = new char[]{'L', 'B', 'D', 'F', 'U'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[0][Math.abs(j - 2)][i];
                }
            }
            pole = otoceniPole(pre, post, -90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[0][Math.abs(j - 2)][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("R")) {
            pre = new char[]{'R', 'U', 'B', 'D', 'F'};
            post = new char[]{'R', 'B', 'D', 'F', 'U'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[2][j][i];
                }
            }
            pole = otoceniPole(pre, post, 90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[2][j][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("R'")) {
            pre = new char[]{'R', 'B', 'D', 'F', 'U'};
            post = new char[]{'R', 'U', 'B', 'D', 'F'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[2][j][i];
                }
            }
            pole = otoceniPole(pre, post, -90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[2][j][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("E")) {
            pre = new char[]{'L', 'B', 'R', 'F'};
            post = new char[]{'F', 'L', 'B', 'R'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][i][1];
                }
            }
            pole = otoceniPole(pre, post, 90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][i][1] = pole[i][j];
                }
            }
        } else if (otoceni.equals("E'")) {
            pre = new char[]{'F', 'L', 'B', 'R'};
            post = new char[]{'L', 'B', 'R', 'F'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][i][1];
                }
            }
            pole = otoceniPole(pre, post, -90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][i][1] = pole[i][j];
                }
            }
        } else if (otoceni.equals("S")) {
            pre = new char[]{'U', 'R', 'D', 'L'};
            post = new char[]{'R', 'D', 'L', 'U'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][1][i];
                }
            }
            pole = otoceniPole(pre, post, 90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][1][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("S'")) {
            pre = new char[]{'U', 'R', 'D', 'L'};
            post = new char[]{'L', 'U', 'R', 'D'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[j][1][i];
                }
            }
            pole = otoceniPole(pre, post, -90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[j][1][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("M")) {
            pre = new char[]{'B', 'D', 'F', 'U'};
            post = new char[]{'U', 'B', 'D', 'F'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[1][Math.abs(j - 2)][i];
                }
            }
            pole = otoceniPole(pre, post, 90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[1][Math.abs(j - 2)][i] = pole[i][j];
                }
            }
        } else if (otoceni.equals("M'")) {
            pre = new char[]{'U', 'B', 'D', 'F'};
            post = new char[]{'B', 'D', 'F', 'U'};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pole[i][j] = kostka[1][Math.abs(j - 2)][i];
                }
            }
            pole = otoceniPole(pre, post, -90, pole);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    kostka[1][Math.abs(j - 2)][i] = pole[i][j];
                }
            }

//OTÁČENÍ KOPMLETNÍ OSY KOSTKY
        } else if (otoceni.equals("x")) {
            provestPohyby("R M' L'");
        } else if (otoceni.equals("x'")) {
            provestPohyby("R' M L");
        } else if (otoceni.equals("y")) {
            provestPohyby("U E' D'");
        } else if (otoceni.equals("y'")) {
            provestPohyby("U' E D");
        } else if (otoceni.equals("z")) {
            provestPohyby("F S B'");
        } else if (otoceni.equals("z'")) {
            provestPohyby("F' S' B");
        }
    }


    public String provestPohyby(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (p.substring(i, i + 1) != " ") {
                if (i != p.length() - 1) {
                    if (p.substring(i + 1, i + 2).compareTo("2") == 0) {
                        otoceni(p.substring(i, i + 1));
                        otoceni(p.substring(i, i + 1));
                        i++;
                    } else if (p.substring(i + 1, i + 2).compareTo("'") == 0) {
                        otoceni(p.substring(i, i + 2));
                        i++;
                    } else {
                        otoceni(p.substring(i, i + 1));
                    }
                } else {
                    otoceni(p.substring(i, i + 1));
                }
            }
        }
        return p;
    }

    public String optimalizovat(String tahy) {
        for (int i = 0; i < tahy.length(); i++) {
            String tah = tahy.substring(i, i + 1);
            if (!tah.equals(" ") && !tah.equals("'") && !tah.equals("2")) {
                if (i <= tahy.length() - 3) {
                    if (tahy.substring(i + 1, i + 2).compareTo("2") == 0) {
                        if (i <= tahy.length() - 4 && tahy.charAt(i + 3) == tahy.charAt(i)) {
                            if (i <= tahy.length() - 5) {
                                if (tahy.substring(i + 4, i + 5).compareTo("2") == 0) {
                                    tahy = tahy.substring(0, i) + tahy.substring(i + 5);
                                    i--;
                                } else if (tahy.substring(i + 4, i + 5).compareTo("'") == 0) {
                                    tahy = tahy.substring(0, i) + tahy.charAt(i) + tahy.substring(i + 5);
                                    i--;
                                } else {
                                    tahy = tahy.substring(0, i) + tahy.charAt(i) + "'" + tahy.substring(i + 4);
                                    i--;
                                }
                            } else {
                                tahy = tahy.substring(0, i) + tahy.charAt(i) + "'" + tahy.substring(i + 4);
                                i--;
                            }
                        }
                    } else if (tahy.substring(i + 1, i + 2).compareTo("'") == 0) {
                        if (i <= tahy.length() - 4 && tahy.charAt(i + 3) == tahy.charAt(i)) {
                            if (i <= tahy.length() - 5) {
                                if (tahy.substring(i + 4, i + 5).compareTo("2") == 0) {
                                    tahy = tahy.substring(0, i) + tahy.charAt(i) + tahy.substring(i + 5);
                                    i--;
                                } else if (tahy.substring(i + 4, i + 5).compareTo("'") == 0) {
                                    tahy = tahy.substring(0, i) + tahy.charAt(i) + "2" + tahy.substring(i + 5);
                                    i--;
                                } else {
                                    tahy = tahy.substring(0, i) + tahy.substring(i + 4);
                                    i--;
                                }
                            } else {
                                tahy = tahy.substring(0, i) + tahy.substring(i + 4);
                                i--;
                            }
                        }
                    } else {
                        if (i <= tahy.length() - 3 && tahy.charAt(i + 2) == tahy.charAt(i)) {
                            if (i <= tahy.length() - 4) {
                                if (tahy.substring(i + 3, i + 4).compareTo("2") == 0) {
                                    tahy = tahy.substring(0, i) + tahy.charAt(i) + "'" + tahy.substring(i + 4);
                                    i--;
                                } else if (tahy.substring(i + 3, i + 4).compareTo("'") == 0) {
                                    tahy = tahy.substring(0, i) + tahy.substring(i + 4);
                                    i--;
                                } else {
                                    tahy = tahy.substring(0, i) + tahy.charAt(i) + "2" + tahy.substring(i + 3);
                                    i--;
                                }
                            } else {
                                tahy = tahy.substring(0, i) + tahy.charAt(i) + "2" + tahy.substring(i + 3);
                                i--;
                            }
                        }
                    }
                }
            }
        }
        return tahy;
    }

    public String generatorZamichani() {
        String zamichani = "";
        char[] pohyby = new char[]{'U', 'D', 'R', 'L', 'F', 'B'};
        char pre = pohyby[(int) (Math.random() * 6)];
        char dalsi = pohyby[(int) (Math.random() * 6)];

        for (int x = 0; x < 20; ) {
            char tah = pohyby[(int) (Math.random() * 6)];
            if (tah != pre && tah != dalsi) {
                int a = (int) (Math.random() * 100);
                if (a < 33) {
                    zamichani += tah + "2 ";
                } else if (a < 67) {
                    zamichani += tah + "' ";
                } else {
                    zamichani += tah + " ";
                }
                dalsi = pre;
                pre = tah;
                x++;
            }
        }
        return zamichani;
    }

    public String slot(int x, int y, int z, char barva) {
        int a = 0;
        KostickaBarva[] b = kostka[x][y][z].getBarvy();

        while ((b[0].getBarva() == barva || b[1].getBarva() == barva) && a < 5) {
            provestPohyby("U");
            b = kostka[x][y][z].getBarvy();
            a++;
        }

        if (a == 0 || a == 4) {
            return "";
        } else if (a == 1) {
            return "U ";
        } else if (a == 2) {
            return "U2 ";
        } else {
            return "U' ";
        }
    }

    public void zamichat(String zamichani) {
        provestPohyby(zamichani);
    }

    public String bileHrany() {
        String pohyby = "";

        if (pocetBilychHran() < 5) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (kostka[i][j][2].isHrana()) {
                        if (kostka[i][j][2].getSmerBarvy('W') == 'D') {
                            pohyby += slot(i, j, 0, 'W');
                            char x = kostka[i][j][2].orientHrana(i, j);
                            pohyby += provestPohyby("" + x + "2 ");
                        }
                    }
                }
            }
        }

        if (pocetBilychHran() < 5) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (kostka[i][j][2].isHrana()) {
                        if (kostka[i][j][2].getSmerBarvy('W') != 'A' && kostka[i][j][2].getSmerBarvy('W') != 'D') {
                            char x = kostka[i][j][2].orientHrana(i, j);
                            pohyby += slot(i, j, 0, 'W');
                            if (x == 'F') {
                                pohyby += provestPohyby("F' U' R ");
                            } else if (x == 'R') {
                                pohyby += provestPohyby("R' U' B ");
                            } else if (x == 'B') {
                                pohyby += provestPohyby("B' U' L ");
                            } else if (x == 'L') {
                                pohyby += provestPohyby("L' U' F ");
                            }
                        }
                    }
                }
            }
        }

        if (pocetBilychHran() < 5) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (kostka[i][j][1].isHrana()) {
                        KostickaBarva[] x = kostka[i][j][1].getBarvy();
                        for (int k = 0; k < 2; k++) {
                            if (x[k].getBarva() == 'W') {
                                if (i == 0 && j == 0) {
                                    if (x[k].getSmer() == 'L') {
                                        pohyby += slot(1, 0, 0, 'W') + provestPohyby("F ");
                                    } else {
                                        pohyby += slot(0, 1, 0, 'W') + provestPohyby("L' ");
                                    }
                                } else if (i == 2 && j == 0) {
                                    if (x[k].getSmer() == 'F') {
                                        pohyby += slot(2, 1, 0, 'W') + provestPohyby("R ");
                                    } else {
                                        pohyby += slot(1, 0, 0, 'W') + provestPohyby("F' ");
                                    }
                                } else if (i == 2 && j == 2) {
                                    if (x[k].getSmer() == 'B') {
                                        pohyby += slot(2, 1, 0, 'W') + provestPohyby("R' ");
                                    } else {
                                        pohyby += slot(1, 2, 0, 'W') + provestPohyby("B ");
                                    }
                                } else {
                                    if (x[k].getSmer() == 'B') {
                                        pohyby += slot(0, 1, 0, 'W') + provestPohyby("L ");
                                    } else {
                                        pohyby += slot(1, 2, 0, 'W') + provestPohyby("B' ");
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

        if (pocetBilychHran() < 5) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (kostka[i][j][0].isHrana()) {
                        if (kostka[i][j][0].getSmerBarvy('W') != 'A' && kostka[i][j][0].getSmerBarvy('W') != 'U') {
                            char x = kostka[i][j][0].orientHrana(i, j);
                            if (x == 'F') {
                                pohyby += provestPohyby("F U' R ");
                            } else if (x == 'R') {
                                pohyby += provestPohyby("R U' B ");
                            } else if (x == 'B') {
                                pohyby += provestPohyby("B U' L ");
                            } else if (x == 'L') {
                                pohyby += provestPohyby("L U' F ");
                            }
                        }
                    }
                }

            }
        }

        if (pocetBilychHran() < 4) {
            pohyby += bileHrany();
        }
        return optimalizovat(pohyby);
    }

    public String bilyKriz() {
        String pohyby = "";

        while (pocetBilychHran() != 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (kostka[i][j][0].isHrana()) {
                        KostickaBarva[] x = kostka[i][j][0].getBarvy();
                        if (x[0].getBarva() == 'W' || x[1].getBarva() == 'W') {
                            for (int k = 0; k < 2; k++) {
                                if ((x[k].getBarva() == 'R' && x[k].getSmer() == 'L') ||
                                        (x[k].getBarva() == 'G' && x[k].getSmer() == 'F') ||
                                        (x[k].getBarva() == 'O' && x[k].getSmer() == 'R') ||
                                        (x[k].getBarva() == 'B' && x[k].getSmer() == 'B')) {
                                    pohyby += provestPohyby(kostka[i][j][0].orientHrana(i, j) + "2 ");
                                }
                            }
                        }
                    }
                }
            }
            pohyby += provestPohyby("U ");
        }
        return optimalizovat(pohyby);
    }

    public String bilaVrstva() {
        String pohyby = "";
        pohyby += bileRohy();
        pohyby += spatneBileRohy();
        while (bilyRohU()) {
            pohyby += bileRohy();
            pohyby += spatneBileRohy();
        }
        return optimalizovat(pohyby);
    }

    public String bileRohy() {
        String pohyby = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (kostka[j][i][0].isRoh() && kostka[j][i][0].isBilyRoh()) {
                    if (j == 0) {
                        if (i == 0) {
                            pohyby += provestPohyby("U' ");
                        } else {
                            pohyby += provestPohyby("U2 ");
                        }
                    } else {
                        if (i == 2) {
                            pohyby += provestPohyby("U ");
                        }
                    }
                    i = 0;
                    j = 0;

                    int UTahy = 0;
                    int yTahy = 0;
                    while (!bilyRohSpravne()) {
                        provestPohyby("U y'");
                        UTahy++;
                        yTahy++;
                    }
                    if (UTahy == 1) {
                        pohyby += "U ";
                    } else if (UTahy == 2) {
                        pohyby += "U2 ";
                    } else if (UTahy == 3) {
                        pohyby += "U' ";
                    }
                    if (yTahy == 1) {
                        pohyby += "y' ";
                    } else if (yTahy == 2) {
                        pohyby += "y2 ";
                    } else if (yTahy == 3) {
                        pohyby += "y ";
                    }

                    int tahy = 0;
                    while (!rohSpravne(2, 0, 2)) {
                        provestPohyby("R U R' U'");
                        tahy++;
                    }
                    if (tahy == 5) {
                        pohyby += "U R U' R' ";
                    } else {
                        for (int k = 0; k < tahy; k++) {
                            pohyby += "R U R' U' ";
                        }
                    }
                }
            }
        }

        return pohyby;
    }

    public String spatneBileRohy() {
        String pohyby = "";
        for (int i = 0; i < 4; i++) {
            pohyby += provestPohyby("y ");
            if (!rohSpravne(2, 0, 2)) {
                if (kostka[2][0][2].isBilyRoh()) {
                    if (!rohSpravne(2, 0, 2)) {
                        pohyby += provestPohyby("R U R' U' ");
                        pohyby += bileRohy();
                    }
                }
            }
        }
        return pohyby;
    }

    public String vlozeniKraju() {
        String pohyby = "";
        pohyby += krajeU();
        pohyby += spatneKraje();
        while (nezluteHranyU()) {
            pohyby += krajeU();
            pohyby += spatneKraje();
        }
        return optimalizovat(pohyby);
    }

    public String krajeU() {
        String pohyby = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (kostka[i][j][0].isHrana() && kostka[i][j][0].getSmerBarvy('Y') == 'A') {
                    if (j == 1) {
                        if (i == 0) {
                            pohyby += provestPohyby("U' ");
                        } else {
                            pohyby += provestPohyby("U ");
                        }
                    } else if (j == 2) {
                        pohyby += provestPohyby("U2 ");
                    }

                    int UTahy = 0;
                    int yTahy = 0;
                    while (kostka[1][0][0].getBarvaSmeru('F') != kostka[1][0][1].getBarvy()[0].getBarva()) {
                        provestPohyby("U y' ");
                        UTahy++;
                        yTahy++;
                    }

                    if (UTahy == 1) {
                        pohyby += "U ";
                    } else if (UTahy == 2) {
                        pohyby += "U2 ";
                    } else if (UTahy == 3) {
                        pohyby += "U' ";
                    }

                    if (yTahy == 1) {
                        pohyby += "y' ";
                    } else if (yTahy == 2) {
                        pohyby += "y2 ";
                    } else if (yTahy == 3) {
                        pohyby += "y ";
                    }

                    if (kostka[1][0][0].getBarvaSmeru('U') == kostka[0][1][1].getBarvy()[0].getBarva()) {
                        pohyby += provestPohyby("U' L' U L U F U' F' ");
                    } else if (kostka[1][0][0].getBarvaSmeru('U') == kostka[2][1][1].getBarvy()[0].getBarva()) {
                        pohyby += provestPohyby("U R U' R' U' F' U F ");
                    }

                    i = 0;
                    j = 0;
                }
            }
        }
        return pohyby;
    }

    public String spatneKraje() {
        String pohyby = "";
        for (int i = 0; i < 4; i++) {
            pohyby += provestPohyby("y ");
            if (kostka[2][0][1].getBarvaSmeru('Y') == 'A' &&
                    kostka[2][0][1].getBarvaSmeru('F') != kostka[1][0][1].getBarvy()[0].getBarva()) {
                if (kostka[2][0][1].getBarvaSmeru('F') == kostka[2][1][1].getBarvy()[0].getBarva() &&
                        kostka[2][0][1].getBarvaSmeru('R') == kostka[1][0][1].getBarvy()[0].getBarva()) {
                    pohyby += provestPohyby("R U R' U2 R U2 R' U F' U' F ");
                } else {
                    pohyby += provestPohyby("R U R' U' F' U' F ");
                    pohyby += krajeU();
                }
            }
        }
        return pohyby;
    }

    public String zlutyKriz() {
        String pohyby = "";
        int a = 0;
        int b = 0;
        int[] c = new int[2];
        int d = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (kostka[i][j][0].isHrana()) {
                    if (kostka[i][j][0].getSmerBarvy('Y') == 'U') {
                        b++;
                    }
                }
            }
        }

 //0
        if (b == 0) {
            pohyby += provestPohyby("F R U R' U' F' U2 F U R U' R' F' ");
        } else if (b == 2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (kostka[i][j][0].isHrana() && kostka[i][j][0].getSmerBarvy('Y') == 'U') {
                        c[d] = i;
                        d++;
                    }
                }
            }
//2
            if (Math.abs(c[0] - c[1]) % 2 == 0) {
                while (kostka[0][1][0].getSmerBarvy('Y') != 'U' || kostka[2][1][0].getSmerBarvy('Y') != 'U') {
                    pohyby += provestPohyby("U ");
                }
                pohyby += provestPohyby("F R U R' U' F' ");
            } else {
//1
                while (kostka[0][1][0].getSmerBarvy('Y') != 'U' || kostka[1][2][0].getSmerBarvy('Y') != 'U') {
                    pohyby += provestPohyby("U ");
                }
                pohyby += provestPohyby("F U R U' R' F' ");
            }
        }
        return optimalizovat(pohyby);
    }

    public String zlutaVrstva() {
        String pohyby = "";
        int a = zluteRohy();

        while (a != 4) {
            if (a == 0) {
                while (kostka[0][0][0].getSmerBarvy('Y') != 'L') {
                    pohyby += provestPohyby("U ");
                }
                pohyby += provestPohyby("R U R' U R U2 R' ");
            } else if (a == 1) {
                while (kostka[0][0][0].getSmerBarvy('Y') != 'U') {
                    pohyby += provestPohyby("U ");
                }
                pohyby += provestPohyby("R U R' U R U2 R' ");
            } else if (a == 2) {
                while (kostka[0][0][0].getSmerBarvy('Y') != 'F') {
                    pohyby += provestPohyby("U ");
                }
                pohyby += provestPohyby("R U R' U R U2 R' ");
            }
            a = zluteRohy();
        }
        return optimalizovat(pohyby);
    }

    public String zbytek() {
        String pohyby = "";
        int a = 0;
        int b = 0;

        for (int i = 0; i < 4; i++) {
            otoceni("y");
            if (kostka[0][0][0].getBarvaSmeru('F') == kostka[2][0][0].getBarvaSmeru('F'))
                a++;
        }

        if (a == 0) {
            pohyby += provestPohyby("R' F R' B2 R F' R' B2 R2 ");
            a = 1;
        }

        if (a == 1) {
            while (kostka[0][2][0].getBarvaSmeru('B') != kostka[2][2][0].getBarvaSmeru('B')) {
                pohyby += provestPohyby("U ");
            }
            pohyby += provestPohyby("R' F R' B2 R F' R' B2 R2 ");
        }

        for (int i = 0; i < 4; i++) {
            otoceni("y");
            if (kostka[0][0][0].getBarvaSmeru('F') == kostka[1][0][0].getBarvaSmeru('F'))
                b++;
        }

        if (b == 0) {
            pohyby += provestPohyby("R2 U R U R' U' R' U' R' U R' ");
            b = 1;
        }

        if (b == 1) {
            while (kostka[0][2][0].getBarvaSmeru('B') != kostka[1][2][0].getBarvaSmeru('B')) {
                pohyby += provestPohyby("U ");
            }
            if (kostka[1][0][0].getBarvaSmeru('F') == kostka[0][0][0].getBarvaSmeru('L')) {
                pohyby += provestPohyby("R2 U R U R' U' R' U' R' U R' ");
            } else {
                pohyby += provestPohyby("R U' R U R U R U' R' U' R2 ");
            }
        }

        while (kostka[0][0][0].getBarvaSmeru('F') != kostka[1][0][1].getBarvy()[0].getBarva()) {
            pohyby += provestPohyby("U ");
        }

        return optimalizovat(pohyby);
    }
}