package org.uma.jmetal.auto.selection.impl;

import org.uma.jmetal.auto.selection.MatingPoolSelection;
import org.uma.jmetal.operator.impl.selection.NaryTournamentSelection;
import org.uma.jmetal.solution.Solution;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NaryTournamentMatingPoolSelection<S extends Solution<?>> implements MatingPoolSelection<S> {
  private NaryTournamentSelection<S> selectionOperator ;
  private int matingPoolSize ;

  public NaryTournamentMatingPoolSelection(int tournamentSize, int matingPoolSize, Comparator<S> comparator) {
    selectionOperator = new NaryTournamentSelection<>(tournamentSize, comparator) ;
    this.matingPoolSize = matingPoolSize ;
  }

  public List<S> select(List<S> solutionList) {
    List<S> matingPool = new ArrayList<>(matingPoolSize) ;

    while (matingPool.size() < matingPoolSize) {
      matingPool.add(selectionOperator.execute(solutionList)) ;
    }

    return matingPool ;
  }
}