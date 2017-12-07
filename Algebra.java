package retre;

import java.util.Scanner;

public class Algebra {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Bem vindo!\n Selecione uma das opções e ela lhes retornará determinada equação.\n");

		double x1, x2, x3, x4, x5;
		double y1, y2, y3, y4, y5;
		double z1, z2, z3, z4;

		int page = -1;

		while (true) {
			if (page == -1) {
				System.out.println("Digite um dos números para começar:\n");
				System.out.println("  1 - Uma reta por dois pontos");
				System.out.println("  2 - Um círculo por 3 pontos");
				System.out.println("  3 - Uma cônica arbitrária por 5 pontos");
				System.out.println("  4 - Um plano por 3 pontos");
				System.out.println("  5 - Uma esfera por 4 pontos");
				System.out.println("  0 - Sair");
				System.out.println();

				page = in.nextInt();

				continue;
			} else if (page == 1) {
				System.out.println("Digite o X e Y do primeiro ponto, separados por espaço:");
				x1 = in.nextDouble();
				y1 = in.nextDouble();

				System.out.println("Digite o X e Y do segundo ponto, separados por espaço:");
				x2 = in.nextDouble();
				y2 = in.nextDouble();

				/*
				     |  x  y  1 |
				 A = | x1 y1  1 |
				     | x2 y2  1 |
				
				 B = | y1  1 |
				     | y2  1 |
				
				 C = | x1  1 |
				     | x2  1 |
				
				 D = | x1 y1 |
				     | x2 y2 |
				
				 |A| = (x * |C|) - (y * |B|) + (|D|)
				 */

				double matrix[][] = new double[][] { { 1, 1, 1 }, { x1, y1, 1 }, { x2, y2, 1 } };

				double determinants[] = determinants(matrix);

				double detB = determinants[0];
				double detC = determinants[1];
				double detD = determinants[2];

				System.out.printf("Equação da reta que passa pelos pontos: %n - (%.0f, %.0f)%n - (%.0f, %.0f)%n", x1,
						y1, x2, y2);
				System.out.printf("%+.0fx%+.0fy%+.0f=0%n", detB, -detC, detD);
			} else if (page == 2) {
				System.out.println("Digite o X e Y do primeiro ponto, separados por espaço:");
				x1 = in.nextDouble();
				y1 = in.nextDouble();

				System.out.println("Digite o X e Y do segundo ponto, separados por espaço:");
				x2 = in.nextDouble();
				y2 = in.nextDouble();

				System.out.println("Digite o X e Y do terceiro ponto, separados por espaço:");
				x3 = in.nextDouble();
				y3 = in.nextDouble();

				/*
				     | ( x² +  y²)  x  y  1 |
				 A = | (x1² + y1²) x1 y1  1 |
				     | (x2² + y2²) x2 y2  1 |
				     | (x3² + y3²) x3 y3  1 |
				
				     | x1 y1  1 |
				 B = | x2 y2  1 |
				     | x3 y3  1 |
				
				     | (x1² + y1²) y1  1 |
				 C = | (x2² + y2²) y2  1 | 
				     | (x3² + y3²) y3  1 |
				
				     | (x1² + y1²) x1  1 |
				 D = | (x2² + y2²) x2  1 | 
				     | (x3² + y3²) x3  1 |
				
					 | (x1² + y1²) x1 y1 |
				 E = | (x2² + y2²) x2 y2 | 
				     | (x3² + y3²) x3 y3 |
				
				 |A| = ((x² + y²) * |B|) - (x * |C|) + (y * |D|) - (|E|)
				 */

				double matrix[][] = new double[][] { { 1, 1, 1, 1 }, { (x1 * x1) + (y1 * y1), x1, y1, 1 },
						{ (x2 * x2) + (y2 * y2), x2, y2, 1 }, { (x3 * x3) + (y3 * y3), x3, y3, 1 } };

				double determinants[] = determinants(matrix);

				double detB = determinants[0];
				double detC = determinants[1];
				double detD = determinants[2];
				double detE = determinants[3];

				System.out.printf(
						"Equação do círculo que passa pelos pontos: %n - (%.0f, %.0f)%n - (%.0f, %.0f)%n - (%.0f, %.0f)%n",
						x1, y1, x2, y2, x3, y3);
				System.out.printf("%+.0f(x² + y²)%+.0fx%+.0fy%+.0f=0%n", detB, -detC, detD, -detE);
			} else if (page == 3) {
				System.out.println("Digite o X e Y do primeiro ponto, separados por espaço:");
				x1 = in.nextDouble();
				y1 = in.nextDouble();

				System.out.println("Digite o X e Y do segundo ponto, separados por espaço:");
				x2 = in.nextDouble();
				y2 = in.nextDouble();

				System.out.println("Digite o X e Y do terceiro ponto, separados por espaço:");
				x3 = in.nextDouble();
				y3 = in.nextDouble();

				System.out.println("Digite o X e Y do quarto ponto, separados por espaço:");
				x4 = in.nextDouble();
				y4 = in.nextDouble();

				System.out.println("Digite o X e Y do quinto ponto, separados por espaço:");
				x5 = in.nextDouble();
				y5 = in.nextDouble();

				/*
				     |  x²  xy   y²  x  y  1 |
				     | x1² x1y1 y1² x1 y1  1 |
				 A = | x2² x2y2 y1² x1 y2  1 |
				     | x3² x3y3 y3² x3 y3  1 |
				     | x4² x4y4 y4² x4 y4  1 |
				     | x5² x5y5 y5² x5 y5  1 |
				
				     | x1y1 y1² x1 y1  1 |
				     | x2y2 y2² x2 y2  1 |
				 B = | x3y3 y3² x3 y3  1 |
				     | x4y4 y4² x4 y4  1 |
				     | x5y5 y5² x5 y5  1 |
				
				     | x1² y1² x1 y1  1 |
				     | x2² y2² x2 y2  1 |
				 C = | x3² y3² x3 y3  1 |
				     | x4² y4² x4 y4  1 |
				     | x5² y5² x5 y5  1 |
				
				     | x1² x1y1 x1 y1  1 |
				     | x2² x2y2 x2 y2  1 |
				 D = | x3² x3y3 x3 y3  1 |
				     | x4² x4y4 x4 y4  1 |
				     | x5² x5y5 x5 y5  1 |
				
				     | x1² x1y1 y1² y1  1 |
				     | x2² x2y2 y2² y2  1 |
				 E = | x3² x3y3 y3² y3  1 |
				     | x4² x4y4 y4² y4  1 |
				     | x5² x5y5 y5² y5  1 |
				
				     | x1² x1y1 y1² x1  1 |
				     | x2² x2y2 y2² x2  1 |
				 F = | x3² x3y3 y3² x3  1 |
				     | x4² x4y4 y4² x4  1 |
				     | x5² x5y5 y5² x5  1 |
				
				     | x1² x1y1 y1² x1 y1 |
				     | x2² x2y2 y2² x2 y2 |
				 G = | x3² x3y3 y3² x3 y3 |
				     | x4² x4y4 y4² x4 y4 |
				     | x5² x5y5 y5² x5 y5 |
				
				 |A| = (x² * |B|) - (xy * |C|) + (y² * |D|) - (x * |E|) + (y * |F|) - (|G|)
				 */

				double matrix[][] = new double[][] { { 1, 1, 1, 1, 1, 1 },
						{ (x1 * x1), (x1 * y1), (y1 * y1), x1, y1, 1 }, { (x2 * x2), (x2 * y2), (y2 * y2), x2, y2, 1 },
						{ (x3 * x3), (x3 * y3), (y3 * y3), x3, y3, 1 }, { (x4 * x4), (x4 * y4), (y4 * y4), x4, y4, 1 },
						{ (x5 * x5), (x5 * y5), (y5 * y5), x5, y5, 1 } };

				double determinants[] = determinants(matrix);

				double detB = determinants[0];
				double detC = determinants[1];
				double detD = determinants[2];
				double detE = determinants[3];
				double detF = determinants[4];
				double detG = determinants[5];

				System.out.printf(
						"Equação da cônica que passa pelos pontos: %n - (%.0f, %.0f)%n - (%.0f, %.0f)%n - (%.0f, %.0f)%n - (%.0f, %.0f)%n - (%.0f, %.0f)%n",
						x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);
				System.out.printf("%+.0fx²%+.0fxy%+.0fy²%+.0fx%+.0fy%+.0f=0%n", detB, -detC, detD, -detE, detF, -detG);
			} else if (page == 4) {
				System.out.println("Digite o X e Y e Z do primeiro ponto, separados por espaço:");
				x1 = in.nextDouble();
				y1 = in.nextDouble();
				z1 = in.nextDouble();

				System.out.println("Digite o X e Y e Z do segundo ponto, separados por espaço:");
				x2 = in.nextDouble();
				y2 = in.nextDouble();
				z2 = in.nextDouble();

				System.out.println("Digite o X e Y e Z do terceiro ponto, separados por espaço:");
				x3 = in.nextDouble();
				y3 = in.nextDouble();
				z3 = in.nextDouble();

				/*
				     |  x  y  z  1 |
				 A = | x1 y1 z1  1 |
				     | x2 y2 z2  1 |
				     | x3 y3 z3  1 |
				
				     | y1 z1  1 |
				 B = | y2 z2  1 |
				     | y3 z3  1 |
				
				     | x1 z1  1 |
				 C = | x2 z2  1 |
				     | x3 z3  1 |
				
				     | x1 y1  1 |
				 D = | x2 y2  1 |
				     | x3 y3  1 |
				
				     | x1 y1 z1 |
				 E = | x2 y2 z2 |
				     | x3 y3 z3 |
				
				 |A| = (x * |B|) - (y * |C|) + (z * |D|) - (|E|)
				 */

				double matrix[][] = new double[][] { { 1, 1, 1, 1 }, { x1, y1, z1, 1 }, { x2, y2, z2, 1 },
						{ x3, y3, z3, 1 } };

				double determinants[] = determinants(matrix);

				double detB = determinants[0];
				double detC = determinants[1];
				double detD = determinants[2];
				double detE = determinants[3];

				System.out.printf(
						"Equação do plano que passa pelos pontos: %n - (%.0f, %.0f, %.0f)%n - (%.0f, %.0f, %.0f)%n - (%.0f, %.0f, %.0f)%n",
						x1, y1, z1, x2, y2, z2, x3, y3, z3);
				System.out.printf("%+.0fx%+.0fy%+.0fz%+.0f=0%n", detB, -detC, detD, -detE);
			} else if (page == 5) {
				System.out.println("Digite o X e Y e Z do primeiro ponto, separados por espaço:");
				x1 = in.nextDouble();
				y1 = in.nextDouble();
				z1 = in.nextDouble();

				System.out.println("Digite o X e Y e Z do segundo ponto, separados por espaço:");
				x2 = in.nextDouble();
				y2 = in.nextDouble();
				z2 = in.nextDouble();

				System.out.println("Digite o X e Y e Z do terceiro ponto, separados por espaço:");
				x3 = in.nextDouble();
				y3 = in.nextDouble();
				z3 = in.nextDouble();

				System.out.println("Digite o X e Y e Z do quarto ponto, separados por espaço:");
				x4 = in.nextDouble();
				y4 = in.nextDouble();
				z4 = in.nextDouble();

				/*
				     | ( x² +  y² +  z²)  x  y  z  1 |
				     | (x1² + y1² + z1²) x1 y1 z1  1 |
				 A = | (x2² + y2² + z2²) x2 y2 z2  1 |
				     | (x3² + y3² + z3²) x3 y3 z3  1 |
				     | (x4² + y4² + z4²) x4 y4 z4  1 |
				
				     | x1 y1 z1  1 |
				 B = | x2 y2 z2  1 |
				     | x3 y3 z3  1 |
				     | x4 y4 z4  1 |
				
				     | (x1² + y1² + z1²) y1 z1  1 |
				 C = | (x2² + y2² + z2²) y2 z2  1 |
				     | (x3² + y3² + z3²) y3 z3  1 |
				     | (x4² + y4² + z4²) y4 z4  1 |
				
				     | (x1² + y1² + z1²) x1 z1  1 |
				 D = | (x2² + y2² + z2²) x2 z2  1 |
				     | (x3² + y3² + z3²) x3 z3  1 |
				     | (x4² + y4² + z4²) x4 z4  1 |
				
				     | (x1² + y1² + z1²) x1 y1  1 |
				 E = | (x2² + y2² + z2²) x2 y2  1 |
				     | (x3² + y3² + z3²) x3 y3  1 |
				     | (x4² + y4² + z4²) x4 y4  1 |
				
				     | (x1² + y1² + z1²) x1 y1 z1 |
				 F = | (x2² + y2² + z2²) x2 y2 z2 |
				     | (x3² + y3² + z3²) x3 y3 z3 |
				     | (x4² + y4² + z4²) x4 y4 z4 |
				
				 |A| = ((x² + y² + z²) * |B|) - (x * |C|) + (y * |D|) - (z * |E|) + (|F|)
				 */

				double matrix[][] = new double[][] { { 1, 1, 1, 1, 1 },
						{ (x1 * x1) + (y1 * y1) + (z1 * z1), x1, y1, z1, 1 },
						{ (x2 * x2) + (y2 * y2) + (z2 * z2), x2, y2, z2, 1 },
						{ (x3 * x3) + (y3 * y3) + (z3 * z3), x3, y3, z3, 1 },
						{ (x4 * x4) + (y4 * y4) + (z4 * z4), x4, y4, z4, 1 } };

				double determinants[] = determinants(matrix);

				double detB = determinants[0];
				double detC = determinants[1];
				double detD = determinants[2];
				double detE = determinants[3];
				double detF = determinants[4];

				System.out.printf(
						"Equação da esfera que passa pelos pontos: %n - (%.0f, %.0f, %.0f)%n - (%.0f, %.0f, %.0f)%n - (%.0f, %.0f, %.0f)%n - (%.0f, %.0f, %.0f)%n",
						x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
				System.out.printf("%+.0f(x² + y² + z²)%+.0fx%+.0fy%+.0fz%+.0f=0%n", detB, -detC, detD, -detE, detF);
			} else if (page == 0) {
				break;
			} else {
				System.out.println("Opção desconhecida, voltando ao menu principal...");

				page = -1;

				continue;
			}

			System.out.println("\nUse ENTER para voltar ao menu principal");

			in.nextLine();
			in.nextLine();

			page = -1;
		}

		System.out.println("Volte sempre!");

		in.close();
	}

	// Pega as determinantes das matrizes que vão ser multiplicadas pelas variáveis
	private static double[] determinants(double matrix[][]) {
		int n, p, q;

		n = matrix.length;

		double det[] = new double[n];

		if (n == 1) {
			det[0] = matrix[0][0];
		} else {
			double b[][] = new double[n - 1][n - 1];
			for (int x = 0; x < n; x++) {
				p = 0;
				q = 0;
				for (int i = 1; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (j != x) {
							b[p][q++] = matrix[i][j];
							if (q % (n - 1) == 0) {
								p++;
								q = 0;
							}
						}
					}
				}
				det[x] = determinant(b, n - 1);
			}
		}

		return det;
	}

	// Encontra a determinante de uma matriz
	private static double determinant(double matrix[][], int n) {
		double det;
		int p, q;

		det = 0;

		if (n == 1) {
			det = matrix[0][0];
		} else {
			double b[][] = new double[n - 1][n - 1];
			for (int x = 0; x < n; x++) {
				p = 0;
				q = 0;
				for (int i = 1; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (j != x) {
							b[p][q++] = matrix[i][j];
							if (q % (n - 1) == 0) {
								p++;
								q = 0;
							}
						}
					}
				}
				det += matrix[0][x] * determinant(b, n - 1) * (x % 2 == 0 ? 1 : -1);
			}
		}

		return det;
	}

}