/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.sakamotodesu.shanghai.solver;

public class App {
    public static void main(String[] args) {
        ShanghaiSolver solver = new ShanghaiSolver();
        //solver.solve(StageData.getNormal());
        //solver.solveByBreadthStart(StageData.getDendo());
        //solver.solverByGraph(StageData.getDendo());
        solver.solveByPoint(StageData.getDendo(), 1);
    }

    public String getGreeting() {
        return "Hello world.";
    }
}
