package sample;

public class Chromosome {

    private int[] genes = new int[Main.GENES_COUNT];
    private float fitness;
    private float likelihood;

    private static int getRandomCrossoverLine() {
        return Main.getRandomInt(0, Main.GENES_COUNT - 2);
    }

    public float getFitness() {
        return fitness;
    }

    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    public int[] getGenes() {
        return genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public float getLikelihood() {
        return likelihood;
    }

    public void setLikelihood(float likelihood) {
        this.likelihood = likelihood;
    }

    public float calculateFitness(int stage, int targetValue) {
        int u = genes[0];
        int y = genes[1];
        int w = genes[2];
        int x = genes[3];
        int z = genes[4];
        int closeness = 0;
        switch (stage) {
            case 0:
                closeness = Math.abs(targetValue - Main.functionOne(u, y, w, x, z));
            case 1:
                closeness = Math.abs(targetValue - Main.functionTwo(u, y, w, x, z));
            default:
                break;
        }
        return 0 != closeness ? 1 / (float) closeness : Main.TARGET_IS_REACHED_FLAG;
    }

    public Chromosome mutateWithGivenLikelihood() {
        Chromosome result = (Chromosome) this.clone();
        for (int i = 0; i < Main.GENES_COUNT; ++i) {
            float randomPercent = Main.getRandomFloat(0, 100);
            if (randomPercent < Main.MUTATION_LIKELIHOOD) {
                int oldValue = result.getGenes()[i];
                int newValue = Main.getRandomGene();
                Main.log("Performing mutation for gene #" + i
                        + ". ( randomPercent ==" + randomPercent
                        + " ). Old value:" + oldValue + "; New value:" + newValue);
                result.getGenes()[i] = newValue;
            }
        }
        return result;
    }

    public Chromosome[] doubleCrossover(Chromosome chromosome) {
        int crossoverline = getRandomCrossoverLine();
        Chromosome[] result = new Chromosome[2];
        result[0] = new Chromosome();
        result[1] = new Chromosome();
        for (int i = 0; i < Main.GENES_COUNT; ++i) {
            if (i <= crossoverline) {
                result[0].getGenes()[i] = this.getGenes()[i];
                result[1].getGenes()[i] = chromosome.getGenes()[i];
            } else {
                result[0].getGenes()[i] = chromosome.getGenes()[i];
                result[1].getGenes()[i] = this.getGenes()[i];
            }
        }
        return result;
    }

    public Chromosome singleCrossover(Chromosome chromosome) {
        Chromosome[] children = doubleCrossover(chromosome);
        int childNumber = Main.getRandomInt(0, 1);
        return children[childNumber];
    }

    public boolean equals(Chromosome chromosome) {
        for (int i = 0; i < Main.GENES_COUNT; ++i) {
            if (this.genes[i] != chromosome.genes[i]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        String[] variables = new String[]{"u = ", "y = ", "w = ", "x = ", "z = "};
        result.append(": (");
        for (int i = 0; i < Main.GENES_COUNT; ++i) {
            result.append(variables[i] + genes[i]);
            result.append(i < Main.GENES_COUNT - 1 ? ", " : "");
        }
        result.append(")\n");
        return result.toString();
    }

    protected Object clone() {
        Chromosome resultChromosome = new Chromosome();
        resultChromosome.setFitness(this.getFitness());
        resultChromosome.setLikelihood(this.getLikelihood());
        int resultGenes[] = this.genes.clone();
        resultChromosome.setGenes(resultGenes);
        return resultChromosome;
    }
}
